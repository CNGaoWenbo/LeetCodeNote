/*
经典题，要熟
【i, L, R】枚举i, 并在每个i的情况从[i+1, length-1]的范围内同时枚举L,R。根据三数枚举和与0比较确定L右移还是R左移。
i,L,R都需要注意去重
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i ++){
            if(nums[i] > 0) break;
            if(i>0 && nums[i] == nums[i-1]) continue;//i去重【注意】跟i-1比，而不是i+1
            int L = i+1;
            int R = nums.length-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));//注意api调用的写法
                    while(L < R && nums[L] == nums[L+1]) L++;//去重
                    while(L < R && nums[R] == nums[R-1]) R--;//去重
                    L++;
                    R--;
                }
                else if(sum < 0){
                    while(L < R && nums[L] == nums[L+1]) L++;
                    L++;
                }else if(sum > 0){
                    while(L < R && nums[R] == nums[R-1]) R--;
                    R--;
                }
            }
        }
        return ans;
    }
}
