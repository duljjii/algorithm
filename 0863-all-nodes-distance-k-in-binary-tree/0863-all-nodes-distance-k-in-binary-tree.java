/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static class Node{
        TreeNode node;
        int depth;
        Node(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        TreeNode[] parentList = new TreeNode[501];
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                q.add(node.left);
                parentList[node.left.val] = node;
            }
            if(node.right != null){
                q.add(node.right);
                parentList[node.right.val] = node;
            }
        }
        Queue<Node> q2 = new LinkedList<>();
        boolean[] visited = new boolean[501];
        q2.add(new Node(target, 0));
        visited[target.val] = true;
        while(!q2.isEmpty()){
            if(q2.peek().depth == k) break;
            Node node = q2.poll();
            if(parentList[node.node.val] != null && !visited[parentList[node.node.val].val] ){
                visited[parentList[node.node.val].val] = true;
                q2.add(new Node(parentList[node.node.val], node.depth+1));
            }
            if(node.node.left != null && !visited[node.node.left.val]){
                visited[node.node.left.val] = true;
                q2.add(new Node(node.node.left, node.depth+1));
            }
            if(node.node.right != null && !visited[node.node.right.val] ){
                visited[node.node.right.val] = true;
                q2.add(new Node(node.node.right, node.depth+1));
            }
        }
        List<Integer> answer = new ArrayList<>();
        while(!q2.isEmpty()){
            answer.add(q2.poll().node.val);
        }
        Collections.sort(answer, (a1, a2)-> Integer.compare(a2, a1));
        return answer;
    }
}