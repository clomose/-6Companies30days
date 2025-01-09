public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        if(root==null){
            str.append(".");
            return str.toString(); 
        }
        Queue<TreeNode> q = new LinkedList<>();
        str.append(root.val+"|");
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.remove();
                if(node.left!=null){
                    q.add(node.left);
                    str.append(node.left.val+"|");
                }else{
                    str.append(".|");
                }
                if(node.right!=null){
                    q.add(node.right);
                    str.append(node.right.val+"|");
                }else{
                    str.append(".|");
                }
            }
        }
        str.delete(str.length()-1,str.length());
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String []arr = data.split("\\|");
        // System.out.println(data);
        System.out.println(Arrays.toString(arr));
        int n = arr.length;
        if(arr[0].equals(".")) return null;
        int a =Integer.parseInt(arr[0]);
        TreeNode root = new TreeNode(a);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int index = 0;
        for(int i=0;i<n-2;i++){
            if(arr[i].equals(".")) continue;
            index++;
            TreeNode node = q.remove();
            if(!arr[index].equals(".")){
                int val = Integer.parseInt(arr[index]);
                TreeNode newNode = new TreeNode(val);
                q.add(newNode);
                node.left = newNode;
            }
            if(!arr[index+1].equals(".")){
                int val = Integer.parseInt(arr[index+1]);
                TreeNode newNode = new TreeNode(val);
                q.add(newNode);
                node.right = newNode;
            }
            index++;
        }
        return root;
    }
}
