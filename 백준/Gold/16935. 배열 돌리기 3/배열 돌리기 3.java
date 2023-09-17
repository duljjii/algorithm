import java.io.*;
import java.util.*;

public class Main {

    private static int N, M, R;

    private static int stoi(String str) {
        return Integer.parseInt(str);
    }

    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        arr = new int[N][M];
        R = stoi(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = stoi(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < R; i++) {
            int num = stoi(st.nextToken());
            switch (num) {
                case 1:
                    updown();
                    break;
                case 2:
                    leftright();
                    break;
                case 3:
                    rotate();
                    break;
                case 4:
                    rotate2();
                    break;
                case 5:
                    quarter(1);
                    break;
                case 6:
                    quarter(2);
                    break;
                default:
                    break;
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int[] lst : arr) {
            for(int num : lst){
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void quarter(int num) {
        int[][] temp = new int[arr.length/2][arr[0].length/2];
        int[][] temp2 = new int[arr.length/2][arr[0].length/2];
        int[][] temp3 = new int[arr.length/2][arr[0].length/2];
        int[][] temp4 = new int[arr.length/2][arr[0].length/2];


        get1(temp);

        get2(temp2);

        get3(temp3);

        get4(temp4);
        int n = arr.length;
        int m = arr[0].length;
        if(num==1){
            for (int i = 0; i < arr.length/2; i++) {
                for (int j = 0; j < arr[0].length/2; j++) {
                    arr[i][j] = temp3[i][j];
                }
            }
            for (int i = 0; i < arr.length/2; i++) {
                for (int j = arr[0].length/2; j < arr[0].length; j++) {
                    arr[i][j] = temp[i][j-arr[0].length/2];
                }
            }
            for (int i = arr.length/2; i < arr.length; i++) {
                for (int j = arr[0].length/2; j < arr[0].length; j++) {
                    arr[i][j] = temp2[i-n/2][j-m/2];
                }
            }
            for (int i = n/2; i < n; i++) {
                for (int j = 0; j < m/2; j++) {
                    arr[i][j] = temp4[i-n/2][j];
                }
            }
        }
        else{
            for (int i = 0; i < n/2; i++) {
                for (int j = 0; j < m/2; j++) {
                    arr[i][j] = temp2[i][j];
                }
            }
            for (int i = 0; i < n/2; i++) {
                for (int j = m/2; j < m; j++) {
                    arr[i][j] = temp4[i][j-m/2];
                }
            }
            for (int i = n/2; i <n; i++) {
                for (int j = m/2; j < m; j++) {
                    arr[i][j] = temp3[i-n/2][j-m/2];
                }
            }
            for (int i = n/2; i <n; i++) {
                for (int j = 0; j < m/2; j++) {
                    arr[i][j] = temp[i-n/2][j];
                }
            }
        }


    }

    private static void get4(int[][] temp4) {
        for (int i = arr.length/2; i < arr.length; i++) {
            for (int j = arr[0].length/2; j < arr[0].length; j++) {
                temp4[i-arr.length/2][j-arr[0].length/2] = arr[i][j];
            }
        }
    }

    private static void get3(int[][] temp3) {
        for (int i = arr.length/2; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length/2; j++) {
                temp3[i-arr.length/2][j] = arr[i][j];
            }
        }
    }

    private static void get2(int[][] temp2) {
        for (int i = 0; i < arr.length/2; i++) {
            for (int j = arr[0].length/2; j < arr[0].length; j++) {
                temp2[i][j-arr[0].length/2] = arr[i][j];
            }
        }
    }

    private static void get1(int[][] temp) {
        for (int i = 0; i < arr.length/2; i++) {
            for (int j = 0; j < arr[0].length/2; j++) {
                temp[i][j] = arr[i][j];
            }
        }
    }

    private static void updown() {
        int[][] temp = new int[arr.length][arr[0].length];
        for (int j = 0; j < arr.length; j++) {
            for (int k = 0; k < arr[0].length; k++) {
                temp[j][k] = arr[arr.length - j - 1][k];
            }
        }
        arr = temp;
    }

    private static void leftright() {
        int[][] temp = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                temp[i][j] = arr[i][arr[0].length - j - 1];
            }
        }
        arr = temp;
    }

    private static void rotate() {
        int[][] temp = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                temp[i][j] = arr[arr.length - 1 - j][i];
            }
        }
        arr = temp;
    }

    private static void rotate2() {
        int[][] temp = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                temp[i][j] = arr[j][arr[0].length - 1 - i];
            }
        }
        arr = temp;
    }

}
