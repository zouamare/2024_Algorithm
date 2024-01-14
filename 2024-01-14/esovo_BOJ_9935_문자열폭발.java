package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9935_문자열폭발 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String bombWord = br.readLine();
        int len = bombWord.length(); // 폭발 문자열 길이
        char last = bombWord.charAt(len-1); // 폭발 문자열 마지막 문자

        Stack<Character> stack = new Stack<>();
        for(char ch : input.toCharArray()){
            stack.push(ch);
            // 폭발 문자열과 마지막 문자가 같고 스택에 쌓인 문자가 폭발 문자열보다 길거나 같은 경우
            if(ch==last && stack.size()>=len){
                boolean isBomb = true;
                for(int i=0; i<len; i++){
                    if(stack.get(stack.size()-1-i) != bombWord.charAt(len-1-i)){
                        isBomb = false;
                        break;
                    }
                }

                if(!isBomb) continue;
                for(int i=0; i<len; i++) stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : stack) sb.append(ch);
        System.out.println(sb.length()==0 ? "FRULA" : sb.toString());
    }

}
