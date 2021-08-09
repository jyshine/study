
class ProductSmartStore(object):
    """
    Smartstore 상품 클래스
    Smartstore 상품에 대한 모든 데이타 정보를 가지고 있다.
    """

    def __init__(self):
        """스마트스토어 상품 정보를 스마트스토어에 등록하는 포멧으로 처리한다.
        :param product: 등록/수정 될 상품정보 TOBE
        :param request_action: RequestActionSmartstore 인스턴스
        :param seller_account_info: seller의 계정정보
        :param is_modify: 상품수정 프로세스인가
        """

        super().__init__()
        self.product = dbm.DBManager().find_shop_product_by_id(self.shop_product_id)



    def _make_product_smartstore(self, is_modify=False):
        minor_purchasable = self.product['common']['minorPurchasable']
        url_list = [url["imageUrl"] for url in self.product['common']['images']]
        result_urls = GetImageURL().work(url_list)
        # origin_code = GetOriginCode(self.product).work()
        noti_type = self.product['common']['productInfoProvidedNotice']['notiType']  # 상품정보제공고시 관련 내용
        product_summaray = self.noti_type_classify(noti_type)

        ############################
        # 미성년자 구매 매핑
        ############################
        if minor_purchasable == True:
            minor_purchasable = "Y"
        else:
            minor_purchasable = "N"
        ############################

        origin_code = self.product["common"]["origin"]["regionCode"]
        if origin_code == "00":
            city_code = self.product["common"]["origin"].get("cityCode")
            county_code = self.product["common"]["origin"].get("countryCode")
            if county_code:
                origin_code = county_code
            elif city_code:
                origin_code = city_code
        elif origin_code == "03":  # 기타
            pass
        else:
            origin_code = self.product["common"]["origin"]["countryCode"]

        data = {
            "RequestId": "hyoshincopy",
            "Version": "2.0",
            "SellerId": "oneprice00",
            "Product": {
                "StatusType": "SALE",
                "SaleType": self.product["common"]['productState'],
                "CustomMade": "N",  # 원셀에는 없다
                "CategoryId": self.product['category']['categoryId'],
                "Name": self.product['basic']['productName'] + '상품수정 텟트',
                "SellerManagementCode": self.product["common"].get("sellerManagementCode", ""),
                "SellerBarCode": self.product["common"].get("sellerBarcode", ""),
                "Model": {
                    "ManufacturerName": self.product["basic"].get("manufacturer", ""),
                    "BrandName": self.product["basic"].get("brand", ""),
                    "ModelName": self.product["basic"].get("modelName", "")
                },
                "OriginArea": {
                    "Code": origin_code,
                    "Importer": self.product['common']['origin']['importer'] + "noway",
                },
                "ManufactureDate": f'{self.product["common"]["manufacturingDate"]}' if self.product["common"].get(
                    "manufacturingDate", None) else "",
                "ValidDate": f'{self.product["common"]["validDate"]}' if self.product["common"].get("validDate",
                                                                                                    None) else "",
                "TaxType": self.product['common']['taxType'],
                "MinorPurchasable": minor_purchasable,
                "Image": {
                    "Representative": {
                        "URL": result_urls[0]
                    },
                    "OptionalList": [url for url in result_urls]
                },

                "Delivery": {

                },
                "SellerCommentContent": self.product["etc"].get("sellerCommentContent", ""),
                "SellerCommentUsable": "Y",
                "DetailContent": "detail_content",  # db에는 없음
                "AfterServiceTelephoneNumber": self.product['common']['afterServiceTelephoneNumber'],
                "AfterServiceGuideContent": self.product['common']['afterServiceGuideContent'],
                "SalePrice": int(utils.make_num_without_comma(self.product["basic"]["salePrice"])),
                "StockQuantity": int(utils.make_num_without_comma(self.product["basic"]["stockQuantity"])),
                "ProductSummary": {
                    self.convert_mapping_code("%s" % product_summaray["mapping_code"]): product_summaray
                },
                # "KCCertifiedProductExclusion":"N" if len(self.product['common']['kcCredentials'])>=1 else "Y",
                "KCCertifiedProductExclusion": "Y",
                "SellerDiscount": {},
                # "BrandCertificationYn":"Y",
                # "CertificationList":[
                #         {
                #             "Id":51,
                #             "Name":"한국건설생활환경시험연구원(KCL)",
                #             "Number":"A101R002-17003",
                #             "KindType":"KC",
                #             "Mark":"Y"
                #         }
                # ]
            },
        }
        if is_modify:
            data["Product"]["ProductId"] = self.product_id

        # 이미지가 한 장이 아닌경우 OptionalList 속성을 지워줘야 한다
        if not data["Product"]["Image"]["OptionalList"]:
            data["Product"]["Image"]["OptionalList"].pop("OptionalList", None)

        # # KC인증 대상여부 확인
        # if len(self.product["common"]["kcCredentials"])>=1:
        #     # crdYn의 마지막 숫자가 1이면 인증대상, 2면 인증대상 아님
        #     if self.product["common"]["kcCredentials"][0]["crdYn"][-1]=="1":
        #         data["Product"]["KCCertifiedProductExclusion"]="N"
        #         # data["Product"]["KCExemptionType"]="SAFE_CRITERION"
        #     elif self.product["common"]["kcCredentials"][0]["crdYn"][-1]=="2":
        #         data["Product"]["KCCertifiedProductExclusion"]="Y"

        #############################################
        # 할인 매핑
        #############################################

        # OPEN API의 SellerDiscountType이 True일때
        if self.product["basic"]["benefit"]["usable"]:
            if self.product["basic"]["benefit"]["pc"]['value'] != 0 and \
                    self.product["basic"]["benefit"]["mobile"]['value'] != 0:
                if self.product["basic"]["benefit"]["pc"]['value'] < data["Product"]["SalePrice"] and \
                        self.product["basic"]["benefit"]["mobile"]['value'] < data["Product"]["SalePrice"]:
                    data["Product"]["SellerDiscount"]["MobileAmount"] = str(
                        self.product["basic"]["benefit"]["mobile"]["value"])
                    data["Product"]["SellerDiscount"]["Amount"] = str(self.product["basic"]["benefit"]["pc"]["value"])
                else:
                    raise BusinessException("할인은 판매가 미만으로 입력해주세요")
            else:
                if self.product["basic"]["benefit"]["pc"]["value"] != 0:
                    if self.product["basic"]["benefit"]["pc"]['value'] < data["Product"]["SalePrice"]:
                        data["Product"]["SellerDiscount"]["Amount"] = str(self.product["basic"]["benefit"]["pc"]["value"])
                        data["Product"]["SellerDiscount"]["MobileAmount"] = 0
                    else:
                        raise BusinessException("할인은 판매가 미만으로 입력해주세요")
                if self.product["basic"]["benefit"]["mobile"]["value"] != 0:
                    if self.product["basic"]["benefit"]["mobile"]['value'] < data["Product"]["SalePrice"]:
                        data["Product"]["SellerDiscount"]["MobileAmount"] = str(
                            self.product["basic"]["benefit"]["mobile"]["value"])
                        data["Product"]["SellerDiscount"]["Amount"] = 0
                    else:
                        raise BusinessException("할인은 판매가 미만으로 입력해주세요")
        else:
            del data["Product"]["SellerDiscount"]

        # 판매 날짜가 존재하면
        # compass에서 {$and:[{$and:[{"etc.saleStartDate":{$exists:true}},{"etc.saleStartDate":{$nin:[""]}}]},{shopType:"SMART_STORE"}]} 로 찾자

        if self.product["etc"].get("saleStartDate", "") and self.product["etc"].get("saleEndDate", ""):
            data["Product"]["SaleStartDate"] = self.product["etc"]["saleStartDate"]
            data["Product"]["SaleEndDate"] = self.product["etc"]["saleEndDate"]

        #############################################
        # 배송 타입 매핑
        #############################################

        # 배송 없는 상품이라면
        if not self.product["etc"]["deliveryInfo"]["deliveryType"]:
            data["Product"].pop("Delivery", None)
        # 배송 있는 상품이라면
        elif self.product["etc"]["deliveryInfo"]["deliveryType"]:
            if self.product["etc"]["deliveryInfo"]["deliveryType"] == "DELIVERY":
                data["Product"]["Delivery"]["Type"] = "1"
            elif self.product["etc"]["deliveryInfo"]["deliveryType"] == "DIRECT":
                data["Product"]["Delivery"]["Type"] = "2"

        #############################################
        # 묶음 배송 가능 여부 매핑
        #############################################
        if self.product["etc"]["deliveryInfo"]["bundleGroup"]["usable"]:
            data["Product"]["Delivery"]["BundleGroupId"] = "Y"

        #############################################
        # 배송비 타입 매핑
        #############################################
        delivery_info = self.product["etc"]["deliveryInfo"]
        deliveryFeePayType = delivery_info["deliveryFeePayType"]
        if deliveryFeePayType == "PREPAID":
            deliveryFeePayType = "2"
        elif deliveryFeePayType == "COLLECT":
            deliveryFeePayType = "1"
        elif deliveryFeePayType == "COLLECT_OR_PREPAID":
            deliveryFeePayType = "3"

        delivery_info = self.product["etc"]["deliveryInfo"]
        deliveryFeeType = delivery_info["deliveryFeeType"]
        if deliveryFeeType == "CONDITIONAL_FREE":
            deliveryFeeType = "2"
            data["Product"]["Delivery"]["FreeConditionalAmount"] = self.product["etc"]["deliveryInfo"].get(
                "freeConditionalAmount", 1)
        elif deliveryFeeType == "UNIT_QUANTITY_PAID":
            deliveryFeeType = "4"
            data["Product"]["Delivery"]["RepeatQuantity"] = self.product["etc"]["deliveryInfo"].get("repeatQuantity", 1)
        elif deliveryFeeType == "RANGE_QUANTITY_PAID":
            deliveryFeeType = "5"
            data["Product"]["Delivery"]["SecondBaseQuantity"] = str(int(delivery_info["freeSectionLastQuantity"]) + 1)
            data["Product"]["Delivery"]["SecondExtraFee"] = utils.make_num_without_comma(delivery_info["secondExtraFee"])
            # 3구간시 필요
            if delivery_info.get("secondSectionLastQuantity", "") != "":
                data["Product"]["Delivery"]["secondSectionLastQuantity"] = delivery_info["secondSectionLastQuantity"]
                data["Product"]["Delivery"]["thirdExtraFee"] = utils.make_num_without_comma(
                    delivery_info.get("thirdExtraFee", 1))
                data["Product"]["Delivery"]["ThirdBaseQuantity"] = 6352,
                data["Product"]["Delivery"]["ThirdExtraFee"] = 5050,
        elif deliveryFeeType == "FREE":
            deliveryFeeType = "1"
        elif deliveryFeeType == "PAID":
            deliveryFeeType = "3"
        else:
            print("====그런 배송비 형식은 없습니다=====")

        #############################################
        # ProductSummary 설정
        #############################################
        request_key = ['NoRefundReason', 'ReturnCostReason', 'QualityAssuranceStandard', 'CompensationProcedure',
                       'TroubleShootingContents']
        request_value = ["상품상세참조" for i in range(5)]
        common_code_data = self.noti_type_classify(self.product["common"]["productInfoProvidedNotice"]["notiType"])
        for k, v in common_code_data.items():
            if k == "items":
                for i in range(len(v)):
                    request_key.append(self.make_upper(v[i]['mapping_code']))

        #############################################
        # 상품정보고시
        #############################################
        if not product_summaray:
            raise DataException("상품정보제공고시 유형 오류 : %s" % self.product["common"]["productInfoProvidedNotice"]["notiType"])
        arr = self.product['common']['productInfoProvidedNotice']['items']
        for i in range(len(arr)):
            request_value.append(arr[i]['value'])
        data['Product']['ProductSummary'][self.convert_mapping_code("%s" % product_summaray["mapping_code"])] = dict(
            zip(request_key, request_value))
        #############################################

        if delivery_info["deliveryType"] == "NONE":
            pass
        else:
            data["Product"]["Delivery"] = {
                "AttributeType": delivery_info["deliveryAttributeType"],
                "FeeType": deliveryFeeType,
                "BaseFee": int(utils.make_num_without_comma(delivery_info.get("baseFee", "0"))),
                "PayType": deliveryFeePayType,
                "ReturnFee": int(utils.make_num_without_comma(delivery_info["returnDeliveryFee"])),
                "ExchangeFee": int(utils.make_num_without_comma(delivery_info["exchangeDeliveryFee"])),
                "ReturnDeliveryCompanyPriority": "0",
                "InstallationFee": "N",
                **data["Product"]["Delivery"]
            }
            # 묶음배송 가능
            if delivery_info["bundleGroup"]["usable"]:
                # 배송비 묶음그룹
                data["Product"]["Delivery"]["BundleGroupAvailable"] = "Y"
                # data["Product"]["Delivery"]["BundleGroupId"] = delivery_info["bundleGroup"]["bundleGroupId"]
                # 묶음 배송 그룹 코드는 ManageBundleGroup, GetBundleGroupList API를 사용하고 나온 리턴값을 써야 한다.
                # data["Product"]["Delivery"]["BundleGroupId"] = delivery_info["bundleGroup"]["bundleGroupId"]
                ######!#######임시 null ############
                data["Product"]["Delivery"]["BundleGroupId"] = None
            else:
                data["Product"]["Delivery"]["BundleGroupAvailable"] = "N"
            # # 묶음배송 불가
            # else:
            #     # 제주/도서산간 추가배송비 설정
            #     if delivery_info["differentialFee"]["usable"]:
            #         jeju_island = data["product"]["Delivery"]["deliveryFee"]["deliveryFeeByArea"] = {}
            #         # 3권역으로 설정
            #         jeju_island["deliveryAreaType"] = "AREA_3"
            #         jeju_island["area2extraFee"] = utils.make_num_without_comma(delivery_info["differentialFee"]["differentialFeeByJeju"])
            #         jeju_island["area3extraFee"] = utils.make_num_without_comma(delivery_info["differentialFee"]["differentialFeeByMountain"])

        certified_required_categories = ['HomeAppliances', 'ImageAppliances', 'Furniture', 'SeasonAppliances',
                                         'OfficeAppliances',
                                         'OpticsAppliances', 'MicroElectronics', 'Navigation', 'CarArticles',
                                         'Cosmetic', 'Kids']
        # ! DB common_code에 CertificationType으로 보내면 에러나서 Certified으로 바꿔준다
        for category in data['Product']['ProductSummary'].keys():
            if category in certified_required_categories:
                for key, value in data['Product']['ProductSummary'][category].items():
                    if key == 'CertificationType':
                        data['Product']['ProductSummary'][category]['Certified'] = value
                        del data['Product']['ProductSummary'][category][key]
        self.data = data