package coding_test.Y2024.M01.D14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9078_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int testcase = 0; testcase < T; testcase++){
            int N = Integer.parseInt(br.readLine());
            int[] number = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                number[i] = Integer.parseInt(st.nextToken());
            }
            int count = 0;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < i + 1 && j < N; j++){
                    if(number[i] > number[j]){
                        count++;
                    }
                }
            }

            // 결과를 출력한다.
            if(count % 2 == 0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
