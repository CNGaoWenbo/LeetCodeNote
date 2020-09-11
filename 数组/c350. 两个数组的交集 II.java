class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> ans = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0;
        int j = 0;
        while(i < len1 && j < len2){
            if(nums1[i] == nums2[j]) {
                ans.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] > nums2[j]) j++;
            else i++;
        }
        int[] ansArr = new int[ans.size()];
        for(int p = 0; p < ans.size(); p++){
            ansArr[p] = ans.get(p);
        }
        return ansArr;
    }
}
