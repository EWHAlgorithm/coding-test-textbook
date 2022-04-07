package DFS_BFS;

import java.util.Scanner;

/**
 * N개의 수로 이루어진 수열 주어짐
 * 수와 수 사이에 끼워 넣을 수 있는 N-1개의 연산자 주어짐 (+, -, x, /)
 * 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램
 *
 * dfs 사용해야할 듯 모든 경우 다 시행해봐야 함..?
 */

public class Q19 {
    // 수열 받을 리스트 선언
    public static int[] seq = new int[11];
    public static int add, sub, mul, div, n;

    // 최솟값과 최댓값 초기화
    public static int minValue = (int) 1e9;
    public static int maxValue = (int) -1e9;

    public static void dfs(int op, int num) {
        // 모든 연산자 사용한 경우
        if(op == n) {
            minValue = Math.min(minValue, num);
            maxValue = Math.max(maxValue, num);
        }
        else {
            if(add>0) {
                add--;
                dfs(op+1, num + seq[op]);
                add++;
            }
            if(sub>0) {
                sub--;
                dfs(op+1, num - seq[op]);
                sub++;
            }
            if(mul>0) {
                mul--;
                dfs(op+1, num * seq[op]);
                mul++;
            }
            if(div>0) {
                div--;
                dfs(op+1, num / seq[op]);
                div++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i=0; i<n; i++) {
            seq[i] = sc.nextInt();
        }

        add = sc.nextInt(); sub = sc.nextInt();
        mul = sc.nextInt(); div = sc.nextInt();

        dfs(1, seq[0]);

        System.out.println(maxValue);
        System.out.println(minValue);

    }
}
