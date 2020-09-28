class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        for(int i = 0; i < len/2; i ++){
            char temp = s[i];
            s[i] = s[len-i-1];//len-1而不是len,索引数超标
            s[len-i-1] = temp;
        }
    }
}
