/*
原地算法，先整体翻转，再对两个子数组翻转
*/
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] nums, int L, int R){
        while(L<R){
            int temp = nums[L];
            nums[L] = nums[R];
            nums[R] = temp;
            L++;
            R--;
        }
    }
}
