def is_admin(f):
    def wrapper(*args, **kwargs):
        for key in kwargs.keys():
            print(key)
        if kwargs.get('username') != 'admin':
            raise Exception("This user is not allowed to get food")
        return f(*args, **kwargs)

    return wrapper()


# def foobar(username="someone"):
#     """ 구현할 메서드 내용 """
#     pass
#
# print(foobar.__doc__)
# print(foobar.__name__)

# 구현할 메서드 내용
# foobar
###############################
