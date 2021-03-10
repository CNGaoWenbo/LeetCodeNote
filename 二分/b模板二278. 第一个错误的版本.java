/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
//模板二
//left < right; right = mid
//target的右邻居是特别的第一个
//GGG[G]BBB
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left < right){
            int mid = left + (right-left)/2;
            if(isBadVersion(mid) == true){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
