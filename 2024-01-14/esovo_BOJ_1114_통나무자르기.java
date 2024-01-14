package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1114_통나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] cuts = new int[K+1]; // 자르는 위치
        for(int k=0; k<K; k++) cuts[k] = Integer.parseInt(st.nextToken());
        cuts[K] = L;
        Arrays.sort(cuts);

        int[] pieces = new int[K+1]; // 잘린 통나무 조각(길이)
        pieces[0] = cuts[0];
        for(int k=1; k<=K; k++) pieces[k] = cuts[k]-cuts[k-1];

        int[] answer = new int[2];
        int left = 0, right = L;
        while(left <= right){
            int mid = (left+right)/2;

            int cnt = 0, loc = 0, sum = 0;
            for(int i=K; i>=0; i--){
                if(pieces[i] > mid){
                    cnt = C+1;
                    break;
                }
                if(pieces[i]+sum > mid){
                    sum = 0;
                    loc = i;
                    cnt++;
                }
                sum += pieces[i];
            }

            if(cnt <= C){
                answer[0] = mid;
                answer[1] = cnt==C ? cuts[loc] : cuts[0];
                right = mid-1;
            }
            else left = mid+1;
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}