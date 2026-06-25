class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = threshold * k;
        int left = 0, right = 0, currSum = 0, count = 0;
        while(right < arr.length){
            currSum+=arr[right];
            if(right-left+1==k){
                if(currSum>=sum) count++;
                currSum-=arr[left];
                left++;
            }
            right++;
        }
        return count;
    }
}