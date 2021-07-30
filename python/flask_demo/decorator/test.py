_functions = {}


def register(f):
    print("test", f)
    global _functions
    _functions[f.__name__] = f
    return f


print(_functions.values())


@register
def foo():
    return 'bar'


class Test(object):
    @register
    def foo2(self):
        return "bar2"


foo()
Test().foo2()
print(_functions.values())
