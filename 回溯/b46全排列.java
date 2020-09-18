/*
看【！注意！】部分
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
            res.add(new ArrayList(path));【！注意！】这里的path传递的是path的地址，所以要new ArrayList(path)复制path的值，否则在返回后path清零，只能得一串空列表到[[],[],..]
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
            res.add(new ArrayList(path));//【！注意！】这里的path传递的是path的地址，所以要new ArrayList(path)复制path的值，否则在返回后path清零，只能得一串空列表到[[],[],..]
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

/*
关于【注意】的测试例子
class Solution {
    public void test() {
    	List<List<Integer>> paths = new ArrayList<>();
    	List<Integer> path = new ArrayList<>();
    	for(int i = 0; i < 3; i ++) {
    		path.add(i);
    	}
    	paths.add(path);//直接传递path，此时System.out.println(paths.get(0).toString()) 的结果是[0,1,2]
    	path.clear();//path清零
    	System.out.println(paths.get(0).toString());结果是[]
    }
}//
