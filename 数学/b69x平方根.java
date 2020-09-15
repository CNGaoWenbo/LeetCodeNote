/*
字节简单面试题
*/
//二分法
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

//牛顿迭代法
class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        double x0 = x;
        while(true){
            double x1 = 0.5*(x0+x/x0);
            if(x0-x1 < 1e-7) break;
            x0 = x1;
        }
        return (int)x0;
    }
}
