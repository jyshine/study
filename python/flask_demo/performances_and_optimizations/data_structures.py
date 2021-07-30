# get() 메서드를 사용하면, 예외를 확인하거나 키 존재 여부를 확인하지 않아도 된다.
# get() 메서드는 None 대신 기본 값을 반환할 수도 있습니다.
# 두 번째 인수로 전달해서 호출

test_dict = dict()
test_dict["key1"] = 'val1'
test_dict["key2"] = "val2"


# print(test_dict["key3"]) 오류 발생
# print(test_dict.get("key3", "val3"))


# set 자료구조에서 제공하는 메서드를 활용하면 중첩되는
# for문이나 if문을 써야 해결할 수 있는 많은 문제를 해결할 수 있습니다.

def has_invalid_fields(fields):
    for field in fields:
        if field not in ['foo', 'bar']:
            return True
    return False


def has_invalid_fields2(fields):
    print(set(fields) - set(['foo', 'bar']))
    return bool(set(fields) - set(['foo', 'bar']))


test_fields = ['test1', 'test2', 'test3', 'test4', 'foo']  # True


# test_fields = ['foo', 'bar'] # False
# print(has_invalid_fields(test_fields))
# print(has_invalid_fields2(test_fields))

# def add_animal_in_family(species, animal, family):
#     if family not in species:
#         # 키 값이 없는 경우 set으로 초기화
#         species[family] = set()
#     species[family].add(animal)
#
#
# species = {}
#
# add_animal_in_family(species, 'cat1', 'felidea')
# add_animal_in_family(species, 'cat2', 'felidea')
# add_animal_in_family(species, 'cat3', 'felidea')
# add_animal_in_family(species, 'cat3', 'felidea')
# add_animal_in_family(species, 'cat4', 'felidea2')
# add_animal_in_family(species, 'cat5', 'felidea2')
# add_animal_in_family(species, 'cat6', 'felidea2')
#
# print(species)
#
# import collections
#
#
# def add_animal_in_family2(species, animal, family):
#     species[family].add(animal)
#
#
# species = collections.defaultdict(set)
# add_animal_in_family2(species, 'cat1', 'felidea')
# add_animal_in_family2(species, 'cat2', 'felidea')
# add_animal_in_family2(species, 'cat3', 'felidea')
# add_animal_in_family2(species, 'cat3', 'felidea')
# add_animal_in_family2(species, 'cat4', 'felidea2')
# add_animal_in_family2(species, 'cat5', 'felidea2')
# add_animal_in_family2(species, 'cat6', 'felidea2')
#
# print(species)

import collections
c = collections.Counter("Premature optimization is the root of all evil. the the the the")
print(c)
for letter in 'the':
    print('%s : %d' % (letter, c[letter]))

# apple3개, banana2개, cherry는 4개
list = ['apple', 'apple', 'apple', 'banana', 'banana',
'cherry', 'cherry', 'cherry', 'cherry']
# 빈도수를 세려면?
counts = collections.Counter(list)
print(counts)
