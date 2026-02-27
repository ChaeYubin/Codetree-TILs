import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.lang.Math;

public class Main {
    static String expression;
    static Map<Character, Integer> alphabetMap;
    static char[] alphabetKeys;
    static int operandCount;  // 선택해야 하는 알파벳 개수
    static int maxResult;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        expression = sc.next();

        alphabetMap = new HashMap<>();

        for (char op : expression.toCharArray()) {
            if (op != '+' && op != '-' && op != '*') {
                alphabetMap.put(op, alphabetMap.getOrDefault(op, 0));
            }
        }

        alphabetKeys = new char[alphabetMap.size()];
        int i = 0;
        for (char key : alphabetMap.keySet()) {
            alphabetKeys[i++] = key;
        }
        
        operandCount = alphabetMap.size();
        
        maxResult = Integer.MIN_VALUE;

        // dfs로 1~4 중에 하나씩 알파벳 개수만큼 선택, Map으로 값 저장
        dfs(0);

        System.out.println(maxResult);
    }

    static void dfs(int index) { 
        // 필요한 알파벳 개수만큼 숫자를 골랐을 때
        if (index == operandCount) { 
            int result = alphabetMap.get(expression.charAt(0));

            for (int i = 1; i < expression.length(); i += 2) {
                int nextNum = alphabetMap.get(expression.charAt(i + 1));

                switch (expression.charAt(i)) {
                    case '+':
                        result += nextNum;
                        break;
                    case '-':
                        result -= nextNum;
                        break;
                    case '*':
                        result *= nextNum;
                        break;
                    default:
                        break;
                }
            }

            maxResult = Math.max(maxResult, result);
            return;
        }

        for (int i = 1; i <= 4; i++) {
            // index번째 알파벳의 값을 i로 선택
            alphabetMap.put(alphabetKeys[index], i);
            dfs(index + 1);
        }
    }
}