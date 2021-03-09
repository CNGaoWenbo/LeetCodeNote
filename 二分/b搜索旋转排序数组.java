//各种等号细节
//先判段哪段有序，在有序段内操作//如果有序段不包含，那去掉这条有序段
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null) return -1;
        if(nums.length == 1) return nums[0] == target ? 0 : -1;
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] >= nums[0]){//0-mid有序
                if(target < nums[mid] && target >= nums[0] ){//target在0-mid
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{//mid-end有序
                if(target <= nums[nums.length-1] && target > nums[mid]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
