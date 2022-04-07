package DFS_BFS;

import java.util.*;

/**
 * N x N 크기의 시험관, 특정 위치에 바이러스 존재
 * 바이러스 종류는 1 ~ K번까지 K가지
 * 시험관에 존재하는 모든 바이러스는 1초마다 상, 하, 좌, 우의 방향으로 증식
 * 매초 번호가 낮은 종류의 바이러스부터 먼저 증식함
 * 증식 과정에서 특정 칸에 이미 바이러스가 있다면 다른 바이러스가 들어갈 수 없음
 * S초 지난 후에 (x, y)에 존재하는 바이러스의 종류를 출력하는 프로그램
 */

public class Q17 {
    // 맵 정보 받을 2차원 배열 생성
    public static int[][] graph = new int[200][200];

    // 방향 정보
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void dfs(int s) {
        /**
         * 가장 낮은 번호의 바이러스를 찾아 거기서부터 전파해야 함
         * 가장 낮은 번호를 이중 반복문으로 계속 찾아..? 그건 좀 아닌듯...
         *
         */
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int k = sc.nextInt();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        int s = sc.nextInt(); int x = sc.nextInt(); int y = sc.nextInt();
        sc.close();
        dfs(s);

        System.out.println(graph[x-1][y-1]);
    }
}
