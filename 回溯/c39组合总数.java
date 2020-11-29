//2020.11.29
//很顺利
class Solution {
    List<List<Integer>> paths = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, path);
        return paths;
    }

    public void backTrack(int[] candidates, int target, List<Integer> path){
        if(sum(path) == target){
            paths.add(new ArrayList(path));
            return;
        }
        if(sum(path) > target){
            return;
        }
        for(int i = 0; i < candidates.length; i ++){
            if(path.size() != 0 && candidates[i] < path.get(path.size()-1)) continue;
            path.add(candidates[i]);
            backTrack(candidates, target, path);
            path.remove(path.size() - 1);
        }
        return;
    }
    public int sum(List<Integer> nums){
        int res = 0;
        for(int num: nums){
            res += num;
        }
        return res;
    }
}
