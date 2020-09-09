/*
用堆实现O(Nlogk)，第一次不会，隔几天重写一次通过。
重点：map可以覆盖同key的value；优先队列的构造（重写比较器）
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        class qComparator implements Comparator<int[]>{
            public int compare(int[] a, int[] b){
                return a[1]-b[1];
            }
        }
        qComparator comp = new qComparator();
        PriorityQueue<int[]> q = new PriorityQueue<>(comp);
        for(int num:map.keySet()){
            int count = map.get(num);
            if(q.size() < k){
                q.offer(new int[]{num, count});
            }else if(q.size() == k){
                if(q.peek()[1] < count){//堆顶数字出现次数小于现在遍历到的数字
                    q.poll();
                    q.offer(new int[]{num, count});
                }
            }
        }
        
        int[] ans = new int[k];
        for(int i = 0; i < k; i ++){
            ans[i] = q.poll()[0];
        }
        return ans;
        
    }
}
