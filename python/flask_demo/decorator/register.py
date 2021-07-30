_functions = {}


def register(f):
    global _functions
    _functions[f.__name__] = f
    return f

print(_functions.values())

@register
def foo():
    return 'bar'

foo()

print(_functions.values())