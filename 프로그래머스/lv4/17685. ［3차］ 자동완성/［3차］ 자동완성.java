import java.util.*;
import java.io.*;

class Solution {
    
    public static class Node{
        int cnt;
        int leaf;
        Node[] child = new Node[26];
        
        public String toString(){
            return "Node cnt : "+this.cnt + " "  + "leaf cnt : " + leaf;
        }
    }
    
    public int solution(String[] words) {
        
        Node[] root = new Node[26];
        for(String word : words){
            char[] arr = word.toCharArray();
            int alpha = (int)(arr[0]-'a');
            if(root[alpha] == null){
                root[alpha] = new Node();
            }
            Node node = root[alpha]; 
            
            
            node.cnt++;
            for(int i=1; i<arr.length; i++){
                alpha = (int)(arr[i] - 'a');
                if(node.child[alpha] == null){
                    node.child[alpha] = new Node();
                }
                node = node.child[alpha];
                node.cnt++;
                if(i == arr.length){
                    node.leaf++;
                }
                
            }
        }
        
        for(String word : words){
            char[] arr = word.toCharArray();
            Node node = root[(int)(arr[0]-'a')];
            ans++;
            if(node.cnt == 1){
                continue;
            }
            for(int i=1; i<arr.length; i++){
                int alpha = (int) (arr[i] - 'a');
                node = node.child[alpha];
                ans++;
                if(node.cnt == 1){
                    break;
                }
            }
        }
        int answer = 0;
        answer = ans;
        return answer;
    }
    private static int ans;
}