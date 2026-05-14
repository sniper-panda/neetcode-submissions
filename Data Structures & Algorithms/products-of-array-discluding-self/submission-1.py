class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n=len(nums)
        ans = [0]*n

        prefix,suffix=[1]*n,[1]*n

        for i in range(1,n):
            prefix[i]=prefix[i-1]*nums[i-1]

        for i in range(n-2,-1,-1):
            suffix[i]=suffix[i+1]*nums[i+1]

        for i in range(0,n):
            ans[i] = prefix[i]*suffix[i]

        return ans