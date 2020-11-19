class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> paths = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        traceBack(paths, path, 0, 0, n);
        return paths;
    }

    public void traceBack(List<String> paths, StringBuilder path, int left, int right, int n){
        if(left == n && right == n){
            paths.add(path.toString());
            return;
        }
        if(left < n){
            path.append("(");
            traceBack(paths, path, left+1, right, n);
            path.deleteCharAt(path.length()-1);
        }
        if(right < left){
            path.append(")");
            traceBack(paths, path, left, right+1, n);
            path.deleteCharAt(path.length()-1);
        }
    }
}
![Image of Yaktocat](https://octodex.github.com/images/yaktocat.png)
