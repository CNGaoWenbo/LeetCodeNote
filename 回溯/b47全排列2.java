/*
做题记录 9.28 10.09
核心问题在于去重（剪枝）
思路是，先排序让数值相同的数挨着。对相同的数而言，只有第一个数插入才允许后面其他相等的数插入，相当于把相同的数看作不同的数区分开；
例如，[1,1,1,2]，看作[1,1',1'',2]。只有1被写入后才能写1‘，只有1和1’写入后才能写入1‘’
           1,1,1,2
   --------------------
  /       X *    X *     \
  1       1‘    1’‘     2
-----                -----------     
1' 1'' 2            /    X     X
                    1    1'   1''
                  -----  
                 /     X
                 1'    1''
                 |
                 1''

有意思的问题，看【备注】行代码
如果条件!vis[i-1]改为vis[i-1]也可以得到正确答案，但是是1'',1',1的顺序（逆序）。
这样写的问题在于剪掉的是小枝子，而非一开始的大枝子（上图*星号标注的两个枝子），浪费一些时间
*/
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        tracBack(nums, path, vis);
        return res;
    }
    public void tracBack(int[] nums, List<Integer> path, boolean[] vis){
        if(path.size() == nums.length){
            res.add(new ArrayList(path));//【注意】
            return;
        }
        for(int i = 0; i < nums.length; i ++){
            if(vis[i] || (i>0 && nums[i] == nums[i-1] && !vis[i-1])){//【备注】
                continue;
            }
            path.add(nums[i]);
            vis[i] = true;
            tracBack(nums, path, vis);
            path.remove(path.size()-1);
            vis[i] = false;
        }
    }
}
