from typing import List, Dict

def create_dict(name: str, age: int) -> Dict[str, int]:
    dict1={}
    dict1[name]=age
    return dict1

def list_to_dict(words: List[str]) -> Dict[str, int]:
    list2dict={}
    for i in range(len(words)):
        curr = words[i]
        list2dict[curr]=i
    return list2dict


# don't modify code below this line
print(create_dict("Alice", 25))
print(create_dict("Jane", 35))
print(create_dict("Joe", 45))

print(list_to_dict(["Alice", "Jane", "Joe"]))
print(list_to_dict(["Apple", "Banana", "Watermelon", "Pineapple"]))
