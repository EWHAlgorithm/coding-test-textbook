package DFS_BFS;

import java.util.*;

/**
 * 연구소 크기 N x M으로 빈칸(0), 벽(1)으로 이루어져 있음
 * 일부 칸은 바이러스(2)가 존재하며 바이러스는 인접한 빈칸으로 모두 퍼져나갈 수 있음
 * 새로 세울 수 있는 벽의 개수는 3개 (반드시 3개 세워야 함)
 * 벽을 새로 세운 뒤 바이러스가 퍼질 수 없는 곳을 안전 영역이라 할 때
 * 안전 영역 크기의 최댓값을 구하는 프로그램
 */

public class Q16 {
    // 그래프 2차원 배열로 생성
    public static int[][] graph = new int[8][8];
    public static int[][] after = new int[8][8]; // 벽 세운 뒤 그래프
    public static int n,m, result = 0;

    // 방향
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    // 전체 그래프를 탐색하며 벽 3개 세워가며 안전 영역 크기 계산하는 dfs 함수
    public static void dfs(int count) {
        // count가 3이 되면 벽 세우기 그만
        if(count==3) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    after[i][j] = graph[i][j];
                }
            }

            // 바이러스 위치에서 전파하기
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(after[i][j] == 2) {
                        virus(i, j);
                    }
                }
            }

            // 안전 영역의 최댓값 계산
            result = Math.max(result, getSafeArea());
        }

        // 빈 공간에 울타리 설치하기
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                    count++;
                    dfs(count);
                    // 그래프 업데이트 다 끝나고 원래 맵으로 변경해주기
                    graph[i][j] = 0;
                    count--;
                }
            }
        }
    }

    // 안전 영역 계산하는 함수
    private static int getSafeArea() {
        int score = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(after[i][j] == 0) {
                    score++;
                }
            }
        }
        return score;
    }

    // 바이러스 퍼지게 하는 함수
    public static void virus(int x, int y) {
        // 상,하,좌,우 이동하면서 바이러스 퍼질 수 있는 경우 2로 바꿔주기 (바이러스 퍼짐)
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<n && ny>=0 && ny<m) {
                if(after[nx][ny] == 0) {
                    after[nx][ny] = 2;
                    virus(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();

        // 그래프 입력 받기
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        dfs(0);
        System.out.println(result);
        sc.close();
    }
}
