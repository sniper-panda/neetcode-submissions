import heapq
from typing import List


def get_reverse_sorted(nums: List[int]) -> List[int]:
    result = []
    nums = [-1*n for n in nums]
    heapq.heapify(nums)

    while nums:
        result.append(heapq.heappop(nums))
    
    result = [-1*n for n in result]
    return result





# do not modify below this line
print(get_reverse_sorted([1, 2, 3]))
print(get_reverse_sorted([5, 6, 4, 2, 7, 3, 1]))
print(get_reverse_sorted([5, 6, -4, 2, 4, 7, -3, -1]))
