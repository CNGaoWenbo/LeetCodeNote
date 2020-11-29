//子集问题
class Solution {
    List<List<Integer>> paths = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();
        backTrack(nums, path, 0);
        return paths;
    }
    public void backTrack(int[] nums, List<Integer> path, int depth){
        paths.add(new ArrayList(path));
        if(depth == nums.length) return;
        for(int i = depth; i < nums.length; i++){
            path.add(nums[i]);
            backTrack(nums, path, i+1);
            path.remove(path.size()-1);
        }
        return;
    }
}
