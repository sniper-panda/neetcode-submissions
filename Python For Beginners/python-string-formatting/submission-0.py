def say_goodbye(name: str, hour: int) -> str:
    string = "Goodbye, {}. See you again at {} o'clock.".format(name,hour)
    return string


# do not modify below this line
print(say_goodbye("Bob", 12))
print(say_goodbye("Jane", 4))
print(say_goodbye("NeetCode", 9))
