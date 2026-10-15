import heapq
from typing import List


def heapify_strings(strings: List[str]) -> List[str]:
    string_heap = []
    for x in strings:
        string_heap.append(x)
    heapq.heapify(string_heap)
    return string_heap


def heapify_integers(integers: List[int]) -> List[int]:
    string_heap = []
    for x in integers:
        string_heap.append(x)
    heapq.heapify(string_heap)
    return string_heap


def heap_sort(nums: List[int]) -> List[int]:
    heap = heapify_integers(nums)
    sorted_list = []
    while heap:
        sorted_list.append(heapq.heappop(heap))
    return sorted_list


# do not modify below this line
print(heapify_strings(["b", "a", "e", "c", "d"]))
print(heapify_integers([3, 4, 5, 1, 2, 6]))
print(heap_sort([3, 4, 5, 1, 2, 6]))
