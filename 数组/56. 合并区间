/*
数组，思路简单。注意比较器和List-array的转化写法
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return intervals;
        class arrComparator implements Comparator<int[]>{
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        }//重写比较器，以用于sort()方法
        arrComparator comp = new arrComparator();
        Arrays.sort(intervals, comp);
        List<int[]> ans = new ArrayList<>();
        int right;
        int left;
        ans.add(intervals[0]);
        for(int[] interval:intervals){
            right = ans.get(ans.size()-1)[1];//List表示二维数组，但取值要注意语法
            left = interval[0];
            if(right >= left) {
                ans.get(ans.size()-1)[1] = Math.max(interval[1],ans.get(ans.size()-1)[1]);
            }
            else ans.add(interval);
        }
        return ans.toArray(new int[0][0]);//toArray(传入输出的数组格式)
    }
}
