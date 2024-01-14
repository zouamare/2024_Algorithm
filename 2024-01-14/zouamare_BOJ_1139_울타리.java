package coding_test.Y2024.M01.D14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
참고 : https://code-trainee.tistory.com/entry/%EB%B0%B1%EC%A4%80-1139-%EC%9A%B8%ED%83%80%EB%A6%AC-JAVA-%EC%9E%90%EB%B0%94
 */
public class BOJ_1139_울타리 {
    static int fenceCnt;
    static int[] fences;
    static double maxDim;
    static double[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fenceCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        fences = new int[fenceCnt];
        maxDim = 0;

        Arrays.sort(fences);

        for(int i = 0; i < fenceCnt; i++){
            fences[i] = Integer.parseInt(st.nextToken());
        }

        dp = new double[fenceCnt][1 << fenceCnt];
        for(int i = 0 ; i < fenceCnt; i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(solve(0, 0));
    }

    private static double solve(int idx, int bitmask) {
        if(idx == fences.length){
            return 0;
        }

        if(dp[idx][bitmask] != -1){
            return dp[idx][bitmask];
        }

        double maxArea = solve(idx + 1, bitmask);

        for(int i = 0; i < fenceCnt; i++){
            for(int j = 0; j < fenceCnt; j++){
                for(int k = 0; k < fenceCnt; j++){
                    if((bitmask & (1 << i)) == 0 && (bitmask & (1 << j)) == 0 && (bitmask & (1 << k)) == 0){
                        if(fences[i] + fences[j] > fences[k]){
                            double area = getDim(fences[i], fences[j], fences[k]);
                            int newBitmask = bitmask | (1 << i) | (1 << j) | (1<<k);
                            maxDim = Math.max(maxDim, area + solve(idx + 1, newBitmask));
                        }
                    }
                }
            }
        }
        return dp[idx][bitmask] = maxArea;
    }

    private static double getDim(int A, int B, int C) {
        double P = (A + B + C) / 2.0;

        return Math.sqrt(P * (P - A) * (P - B) * (P - C));
    }
}
