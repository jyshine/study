# identity
def identity(f):
    print('identity decorator')
    return f


@identity
def foo():
    return 'bar'

foo()

"""
데커레이터를 추가하면 아래와 같이 작성하는 것과 동일하다. 
foo = identity(foo)
"""
