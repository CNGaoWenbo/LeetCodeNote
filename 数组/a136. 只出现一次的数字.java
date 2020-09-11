/*
异或位运算的性质：
a异或0 = a 任何数和0异或都是它本身
a异或a = 0 任何数自己异或自己都是0
abc=acb 异或满足交换律和结合律

只需要将所有的数逐个异或一遍，就会剩下单独的数

其他位运算的总结：https://blog.csdn.net/xiaochunyong/article/details/7748713
*/
class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for(int num:nums){
            single ^= num;
        }
        return single;
    }
}
/*
非原地的笨办法
一开始自己想的方法，先排序
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i += 2){
            if(nums[i] != nums[i+1]) return nums[i];
        }
        return nums[nums.length-1];
    }
}

其他的方法 
在集合放入新元素，删除重复元素
哈希表记录出现次数再遍历
*/
