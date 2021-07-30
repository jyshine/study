

class Store(object):
    """
    중복되는 코드를 확인할 수 있음.
    """
    def get_food(self, username, food):
        if username != 'admin':
            raise Exception('This user is not allowd to get food')
        return self.storage.get(food)

    def put_food(self, username, food):
        if username != 'admin':
            raise Exception('This user is not allowd to put food')
        return self.storage.put(food)
