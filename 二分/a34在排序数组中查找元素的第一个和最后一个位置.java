class Solution {
    public int[] searchRange(int[] nums, int target) {//为了二段性，先找起点，再找终点
        if(nums.length == 0) return  new int[]{-1, -1};
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int mid = left + right >> 1;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        if(nums[left] != target) return new int[]{-1, -1};//如果不是target，说明不存在
        int start = left;
        left = 0;
        right = nums.length-1;
        while(left < right){
            int mid = left + right +1 >> 1;
            if(nums[mid] > target){
                right = mid-1;
            }else{
                left = mid;
            }
        }
        int end = left;
        return new int[]{start, end};
    }
}
