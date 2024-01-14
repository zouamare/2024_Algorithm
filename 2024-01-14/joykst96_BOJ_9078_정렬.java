package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class BOJ9078 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; ++i) list.add(Integer.parseInt(st.nextToken()));
            int target = 1;
            int count = 0;
            int end = (int) Math.pow(n, 2);
            ORDER: while (++count < end) {
                int check = 1;
                for (int i: list) if (check == i) ++check;
                if (check == n + 1) {
                    sb.append("YES\n");
                    break;
                }
                for (int i = 0; i < n; ++i) {
                    if (list.get(i) == target) {
                        if (i == n - 1) {
                            int prev = Objects.hash(list);
                            list.add(target - 1, list.remove(i));
                            list.add(target - 1, list.remove(i));
                            if (prev == Objects.hash(list)) {
                                sb.append("NO\n");
                                break ORDER;
                            }
                        } else {
                            list.add(target - 1, list.remove(i + 1));
                            list.add(target - 1, list.remove(i + 1));
                            ++target;
                        }
                        break;
                    }
                }
            }
        }
        System.out.print(sb.toString());
    }
}
