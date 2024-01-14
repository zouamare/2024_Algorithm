package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9935 {
    static Stack<Character> buffer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        char[] boom = new StringBuilder(br.readLine()).reverse().toString().toCharArray();
        buffer = new Stack<>();
        for (char ch: input) defuse(ch, boom);
        StringBuilder sb = new StringBuilder();
        if (buffer.isEmpty()) sb.append("FRULA");
        else for (char ch: buffer) sb.append(ch);
        System.out.println(sb.toString());
    }

    private static void defuse(char ch, char[] boom) {
        buffer.push(ch);
        defuse(boom);
    }

    private static void defuse(char[] boom) {
        Stack<Character> trash = new Stack<>();
        for (char ch: boom) {
            if (buffer.isEmpty()) {
                while (!trash.isEmpty()) buffer.push(trash.pop());
                return;
            }
            if (ch == buffer.peek()) {
                trash.push(buffer.pop());
            } else {
                while (!trash.isEmpty()) buffer.push(trash.pop());
                return;
            }
        }
        defuse(boom);
    }
}
