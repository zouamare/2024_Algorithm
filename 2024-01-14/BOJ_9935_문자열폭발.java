package coding_test.Y2024.M01.D14;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 문자열의 길이 1 <= n <= 1,000,000
 * 폭발 문자열의 길이 1 <= m <= 36
 *
 * 1) 1차 시도 : 메모리초과, string -> stringbuilder로 변경 => 실패
 * 2) 2차 시도 : 메모리초과, string의 replace -> stringbuilder의 substring => 실패
 * 3) 3차 시도 : 메모리초과, stringbuilder -> 스택으로 변경 => 성공 (36728kb/484ms)
 * */
public class BOJ_9935_문자열폭발 {
    final static String NO_DATA = "FRULA";

    public static void main(String[] args) throws IOException {
        // 1. 문자열, 폭발문자열을 입력받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] rootStr = br.readLine().toCharArray();
        char[] bombStr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        // 2. 스택에 차례대로 넣으면서 탐색하여 폭발문자열이 있으면 제외한다.
        for(int i = 0; i < rootStr.length; i++){
            stack.add(rootStr[i]);

            if(stack.size() >= bombStr.length){
                boolean same = true;
                for(int j = 0; j < bombStr.length; j++){
                    if(stack.get(stack.size() - 1 - j) != bombStr[bombStr.length - 1 - j]){
                        same = false;
                        break;
                    }
                }
                if(same){
                    for(int j = 0; j < bombStr.length; j++){
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(char c : stack){
            sb.append(c);
        }

        // 3. 문자열 폭발이 종료된 결과를 출력한다.
        if(sb.toString().isBlank()){
            System.out.println(NO_DATA);
        }
        else {
            System.out.println(sb.toString());
        }
    }
}
