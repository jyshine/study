def chech_is_admin(username):
    """
    중복되는 코드를 하나의 메소드로 뺌
    :param username:
    :return:
    """
    if username != 'admin':
        raise Exception('This user is not allowd to get food')


class Store(object):

    def get_food(self, username, food):
        chech_is_admin(username)
        return self.storage.get(food)

    def put_food(self, username, food):
        chech_is_admin(username)
        return self.storage.put(food)
