import collections.abc


class CommonDataMatching(object):
    def __init__(self):
        self._result_data = {}

    def common_matching_one_to_one(self, matching_info: dict, input_data: dict):
        """
        [데이터 매칭 One to One]
        -주요기능: matching_info 기준으로 input_data로 변환하여 반환해주는 기능
        -상세설명:
            matching key 값 하위 key에 값을 입력하는 경우 .으로 하위 key를 입력해줍니다.
            ex) "key1.key1-1.key1-1-1,key1-1-1-1: "common.productState",
                => "key1": {
                        "key1-1": {
                            "key1-1-1": {
                                "key1-1-1-1": "value
                            }
                        }
                    },

            matching 값이 array의 특정 필드인 경우 .과  배열 index를 입력하고 필드명 입력해줍니다.
            ex) "대표 이미지 파일명": "common.images.0.imageType",
                => "대표 이미지 파일명": "main",

            matching 값이 배열인 경우 , 로 값을 입력해 줍니다.
            ex) "아이템": "common.productInfoProvidedNotice.items.code"
                => "아이템": "ITEM2114,ITEM2101,ITEM2102,ITEM2103"

        -param matching_info : 매칭할 키 값을 입력해 줍니다. {매칭 키 : 매칭할 데이터 키}
        -param input_data    : 매칭할 데이터
        """

        self._result_data = self._matching(input_data, matching_info, self._result_data)
        return self._result_data

    def _matching(self, input_data, matching_info, result_data):
        for column in matching_info:
            self._matching_data(result_data, column, self._find_value(matching_info[column], input_data))
        return result_data

    def _matching_data(self, result_data, key_name, key_value):
        split_key_name = str.split(key_name, ".")
        if len(split_key_name) > 1:
            multi_key = dict()

            for i in range(0, len(split_key_name)):
                if i == 0:
                    multi_key = dict()
                    multi_key[split_key_name[len(split_key_name) - i - 1]] = key_value
                else:
                    previous_dict = multi_key
                    multi_key = dict()
                    multi_key[split_key_name[len(split_key_name) - i - 1]] = previous_dict
            update(result_data, multi_key)
        else:
            if key_name not in result_data:
                result_data[key_name] = dict()
            if key_value is None:
                key_value = None
            result_data[key_name] = key_value

    def _find_value(self, element, JSON):
        paths = element.split(".")
        data = JSON
        is_list = False

        try:
            for i in range(0, len(paths)):
                if is_list:
                    if len(paths) == (i + 1):
                        data = ','.join([str(elem[paths[i]]) for elem in data])
                    else:
                        data = data[int(paths[i])]
                    is_list = False
                    continue

                if paths[i] in data.keys():
                    data = data[paths[i]]
                    if isinstance(data, list):
                        is_list = True

                else:
                    data = None
        except Exception as e:
            print(e)
            data = None

        return data


def update(d, u):
    for k, v in u.items():
        if isinstance(v, collections.abc.Mapping):
            d[k] = update(d.get(k, {}), v)
        else:
            d[k] = v
    return d
