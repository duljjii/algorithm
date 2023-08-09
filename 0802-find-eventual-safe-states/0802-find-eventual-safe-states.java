import java.util.*;
class Solution {
    public static class Node {
        int idx;
        boolean safe = false;
        boolean visited = false;
        int childCnt = 0;
        List<Node> parentList = new ArrayList<Node>();
        Node(int idx) {
            this.idx = idx;
        }
        public String toString(){
            return idx + " " + safe;
        }
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> answer = new ArrayList<Integer>();

        int idx = 0;
        Node[] nodeList = new Node[graph.length];
        for (int i = 0; i < graph.length; i++) {
            nodeList[i] = new Node(i);
       }
        Queue<Node> q = new LinkedList<>();
        for (int[] childList : graph) {
            if(childList.length == 0){
                nodeList[idx].safe = true;
                q.add(nodeList[idx]);
            }
            for (int child : childList) {
                nodeList[idx].childCnt+=1;
                nodeList[child].parentList.add(nodeList[idx]);
            }
            idx++;
        }
        while(!q.isEmpty()){
            Node node = q.poll();
            answer.add(node.idx);

            for(Node parent : node.parentList){
                parent.childCnt -= 1;
                System.out.println(parent.childCnt);
                if(parent.childCnt == 0){
                    parent.safe = true;
                    q.add(parent);
                }
                }
            }
        
        int cnt = 0;
        Collections.sort(answer);
    return answer;
    }
}