"""
데커레이터를 사용하여 공통 기능으로 만들기
kwargs 변수를 사용하여 함수에 전달된 인수를 검사하고 username 인수를 검색합니다.

"""


def check_is_admin(f):
    def wrapper(*args, **kwargs):
        print(*args)
        print(kwargs.get('username'))
        if kwargs.get('username') != 'admin':
            raise Exception('This user is not allowed to get or put food')
        return f(*args, **kwargs)

    return wrapper


class Store(object):
    @check_is_admin
    def get_food(self, username, food):
        return "self.storage.get(food)"

    @check_is_admin
    def put_food(self, username, food):
        return "self.storage.put(food)"


Store().get_food(username="admin", food="food")

