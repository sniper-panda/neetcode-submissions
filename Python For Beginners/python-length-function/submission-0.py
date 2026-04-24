def get_longer_word(word1: str, word2: str) -> str:
    l1=len(word1)
    l2=len(word2)
    if l1>=l2:
        return word1
    elif l2>l1:
        return word2



# do not modify below this line
print(get_longer_word("yellow", "orange"))
print(get_longer_word("red", "blue"))
print(get_longer_word("green", "blue"))
