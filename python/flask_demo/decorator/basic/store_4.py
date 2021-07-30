"""
단일 함수를 사용하여 하나 이상의 데커레이터 사용하기

check_user_is_not() 데커레이터 user_check_decorator()에 대한 팩터리 함수 입니다.

"""


def check_user_is_not(username):
    print(username)

    def user_check_decorator(f):
        def wrapper(*args, **kwargs):
            print(kwargs.get('username'))
            if kwargs.get('username') == username:
                raise Exception('This user is not allowed to get food')
            return f(*args, **kwargs)

        return wrapper

    return user_check_decorator


class Store(object):
    @check_user_is_not("2")
    @check_user_is_not("1")
    def get_food(self, username, food):
        return "self.storage.get(food)"


Store().get_food(username="admin", food="food")
