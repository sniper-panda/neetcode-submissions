from typing import List

def read_integers() -> List[int]:
    number_string = input()
    number_string = number_string.split(",")
    a=[]
    for n in number_string:
        a.append(int(n))
    return a

# do not modify the code below
print(read_integers())
print(read_integers())
print(read_integers())
