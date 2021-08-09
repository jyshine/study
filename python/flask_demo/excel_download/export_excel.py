from bson import ObjectId
# from db.db_manager import DBManager
import pandas as pd


class ExportToCsv(object):
    def __init__(self):
        super().__init__()
        # self.dbm = DBManager.get_instance()
        self.product = self.dbm.find_one(collection="shop_product", where={"_id": ObjectId("60ffabb8fd278f64ffa98476")})

    def make_dataframe(self):
        result_data = {}
        # 상품상태
        print(self.product['common']['productState'])
        add_dict_data(result_data, 'productState', self.product['common']['productState'])

        # 카테고리ID
        print(self.product['category']['categoryId'])
        add_dict_data(result_data, 'categoryId', self.product['category']['categoryId'])

        # 상품명
        print(self.product['basic']['productName'])
        add_dict_data(result_data, 'productName', self.product['basic']['productName'])

        # 판매가
        print(self.product['basic']['salePrice'])
        add_dict_data(result_data, 'salePrice', self.product['basic']['salePrice'])

        # 재고수량
        print(self.product['basic']['stockQuantity'])
        add_dict_data(result_data, 'stockQuantity', self.product['basic']['stockQuantity'])

        # A/S 안내내용
        print(self.product['common']['afterServiceGuideContent'])
        add_dict_data(result_data, 'afterServiceGuideContent', self.product['common']['afterServiceGuideContent'])

        # A/S 전화번호
        print(self.product['common']['afterServiceTelephoneNumber'])
        add_dict_data(result_data, 'afterServiceTelephoneNumber', self.product['common']['afterServiceTelephoneNumber'])

        # 대표 이미지 파일명

        # 추가 이미지 파일명
        # 상품 상세정보
        # 판매자 상품코드
        # print(result_data)

        df_from_dict = pd.DataFrame.from_dict(result_data)
        excel_writer = pd.ExcelWriter('/Users/sjy/dev/doc/ProductTemplate.xls', mode="a")
        df_from_dict.to_excel(excel_writer, sheet_name='ver.2.1', startrow=5)


def add_dict_data(result_data, key_name, key_value):
    if key_name not in result_data:
        # 키 값이 없는 경우 set으로 초기화
        result_data[key_name] = list()
    if key_value is None:
        key_value = None
    result_data[key_name].append(key_value)


ExportToCsv().make_dataframe()
