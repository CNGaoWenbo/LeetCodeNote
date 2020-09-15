//字节简单面试题
class Solution {
    public int mySqrt(int x) {
        int left = 0, right = x;
        int ans = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            if((long)mid*mid <= x){
                ans = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return ans;
    }
}
