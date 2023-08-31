import java.util.*;
import java.io.*;
public class Main {
    static String s;
    static String bomb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        s = st.nextToken();
        char[] lst = s.toCharArray();
        st = new StringTokenizer(br.readLine()," ");
        bomb = st.nextToken();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<lst.length; i++){
            sb.append(lst[i]);
            if(lst[i] == bomb.charAt(bomb.length()-1)){
                if(sb.length() >= bomb.length()){
                    boolean flag = true;
                    for(int j = 0; j<bomb.length(); j++){
                        if(sb.charAt(sb.length()-1 - j) == bomb.charAt(bomb.length() -1 - j)){
                            continue;
                        }else{
                            flag = false;
                        }

                    }
                    if(flag){
                        sb.delete(sb.length() - bomb.length(), sb.length());
                    }
                }
            }
        }
        if(sb.length() == 0) {
            System.out.println("FRULA");
        }
        else{
            System.out.println(sb.toString());
        }
    }
}
