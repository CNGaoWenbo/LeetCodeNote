/*
递归熟练，迭代半熟，moris完全搞不懂...
*/
//moris中序遍历
class Solution{
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        TreeNode pre = null;
        
        while(root != null){
            if(root.left != null){
                pre = root.left;
                while(pre.right != null && pre.right != root){
                    pre = pre.right;
                }            
                if(pre.right == null){
                    pre.right = root;
                    root = root.left;
                }else{
                    pre.right = null;
                    ans.add(root.val);
                    root = root.right;
                }       
            }else{
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }
}

/*
//递归
class Solution {
    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return list;
        list = inorderTraversal(root.left);
        list.add(root.val);
        list = inorderTraversal(root.right);
        return list;
    }
}

//迭代
class Solution{
    
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
}
*/
