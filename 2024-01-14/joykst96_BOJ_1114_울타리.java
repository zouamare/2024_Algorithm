package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ1114 {
    static int L, K, C;
    static int longest;
    static List<Integer> stick;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        TreeSet<Integer> position = new TreeSet<>(List.of(L));
        for (int i = 0; i < K; ++i) position.add(Integer.parseInt(st.nextToken()));
        stick = new ArrayList<>();
        int prev = 0;
        longest = 0;
        for (int pos: position) {
            stick.add(pos - prev);
            longest = Math.max(longest, pos - prev);
            prev = pos;
        }
        int left = 0;
        int right = L;
        int ansLongest = 0;
        int ansFirstCut = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int[] solve = solve(mid);
            int count = solve[0];
            int firstCut = solve[1];
            if (count <= C) {
                ansLongest = mid;
                ansFirstCut = firstCut;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.printf("%d %d%n", ansLongest, ansFirstCut);
    }

    private static int[] solve(int mid) {
        if (longest > mid) return new int[] {Integer.MAX_VALUE, 0};
        int sum = 0;
        int count = 0;
        for (int i = stick.size() - 1; i >= 0; --i) {
            sum += stick.get(i);
            if (sum > mid) {
                sum = stick.get(i);
                ++count;
            }
        }
        return new int[] {count, count == C ? sum : stick.get(0)};
    }
}
