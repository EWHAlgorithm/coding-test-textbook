package DFS_BFS;

import java.util.*;

/**
 * N x N 크기의 복도, 각 칸에는 선생님(T), 학생(S), 혹은 장애물(O) 있음
 * 학생 몇 명이 수업 시간에 몰래 복도에 나옴 선생님의 감시에 들키지 않는 것이 목표
 * 각 선생님은 자신의 위치에서 상, 하, 좌, 우 4가지 방향으로 감시 진행
 * 아무리 멀리 있더라도 장애물로 막히기 전까지 4방향으로 학생 모두 볼 수 있음
 * 장애물 3개를 설치해 선생님의 감시로부터 모든 학생이 피할 수 있는지 계산
 */

public class Q20 {
    // 맵 정보 입력받을 2차원 배열 선언 (장애물 설치 전 후)
    public static String[][] graph = new String[6][6];
    public static String[][] after = new String[6][6];
    public static int n;
    public static String result;

    // 방향
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    // 전체 그래프를 탐색하며 장애물 3개 세워가며 감시 피할 수 있는지 체크
    public static void dfs(int count) {
        result = "YES";
        // count가 3이 되면 장애물 세우기 그만
        if(count==3) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    after[i][j] = graph[i][j];
                }
            }

            // 선생님 위치에서 학생 감시하기
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(after[i][j].equals("T")) {
                        teacher(i, j);
                    }
                }
            }

            // 한 명의 학생이라도 감시에 걸릴 경우
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                     if(graph[i][j].equals("S"))
                         student(i,j);
                }
            }
        }

        // 빈 공간에 장애물 설치하기
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if (graph[i][j].equals("X")) {
                    graph[i][j] = "O";
                    count++;
                    dfs(count);
                    // 그래프 업데이트 다 끝나고 원래 맵으로 변경해주기
                    graph[i][j] = "X";
                    count--;
                }
            }
        }
    }

    private static void student(int x, int y) {
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if(after[nx][ny].equals("T"))
                    result = "NO"; // 선생님 만나면 NO로 업데이트
            }
        }
    }

    private static void teacher(int x, int y) {
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if(after[nx][ny].equals("X"))
                    after[nx][ny] = "T"; // 선생님이 영향을 미칠 수 있는 곳으로 변경
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // 그래프 정보 입력받기
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                graph[i][j] = sc.next();
            }
        }

        dfs(0);
        System.out.println(result);
        sc.close();
    }
}
