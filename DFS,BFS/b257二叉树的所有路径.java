//简单题，但是递归和dfs不熟悉，还是花了很久
//注意：path不能用StringBuilder，因为StringBuilder可变,在递归的时候会被修改，非同一路径也会写到path里
//例如：原答案 1-2-3,1-5 变成 1-2-3,1-2-35
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        String path = new String();
        dfs(root, paths, path);
        return paths;
    }

    public void dfs(TreeNode root, List<String> paths, String path){
        if(root == null) return;
        StringBuilder pathSB = new StringBuilder(path);
        pathSB.append(root.val);
        if(root.left == null && root.right == null){
            paths.add(pathSB.toString());
        }
        else{
            pathSB.append("->");
            dfs(root.left, paths, pathSB.toString());
            dfs(root.right, paths, pathSB.toString());
        }

    }
}
