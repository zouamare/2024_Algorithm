package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9078_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

            int count = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<i; j++){
                    if(arr[i] < arr[j]) count++;
                }
            }
            System.out.println(count);
            if(count%2 == 0) sb.append("YES\n");
            else sb.append("NO\n");
        }


        System.out.println(sb);
    }
}