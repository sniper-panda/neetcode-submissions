class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // int left = 0, mid = 0, right = nums.length-1;
        for(int left = 0;left<nums.length;left++){
            if(left > 0 && nums[left]==nums[left-1]) continue;
            int mid = left + 1, right = nums.length-1;
            while(mid < right){
                int currSum = nums[left] + nums[mid] + nums[right];
                if(currSum > 0){
                    right--;
                }else if(currSum < 0){
                    mid++;
                }else{
                    List<Integer> smallAns = new ArrayList<>();
                    ans.add(Arrays.asList(nums[left],nums[mid],nums[right]));
                    mid++;
                    right--;

                    while(mid<right && nums[mid]==nums[mid-1]) mid++;
                    while(right>mid && nums[right]==nums[right+1]) right--;
                }
            }
        }
        return ans;
    }
}
