/*
用数组的顺序存储结果，path[0，ptr]是已经选择好的，path[ptr+1, nums.length-1]是为选择的，swap实际就是确定选择和撤销选择回溯
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> path = new ArrayList<>();
        for(int num:nums){
            path.add(num);
        }
        traceBack(nums, path, 0);
        return res;
    }

    public void traceBack(int[] nums, List<Integer> path, int ptr){
        if(ptr == nums.length){
            res.add(new ArrayList(path));
            return;
        }
        for(int i = ptr; i < nums.length; i ++){
            Collections.swap(path, ptr, i);
            traceBack(nums, path, ptr+1);
            Collections.swap(path, ptr, i);
        }
    }
}
*/
//普通的存储方法
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> path = new ArrayList<>();
        traceBack(nums, path);
        return res;
    }

    public void traceBack(int[] nums, List<Integer> path){
        if(path.size() == nums.length){
            res.add(new ArrayList(path));
            return;
        }
        for(int i = 0; i < nums.length; i ++){
            if(path.contains(nums[i])) continue;
            path.add(nums[i]);
            traceBack(nums, path);
            path.remove(path.size()-1);
        }
    }
}
