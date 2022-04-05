package Implementation;

import java.util.Scanner;

public class GameDev {

    public static int n, m, x, y, d;
    // 방문 기록 저장을 위한 맵 0으로 초기화 (가보지 않은 곳 체크용)
    public static int[][] visited = new int[50][50];
    // 현재 맵 정조 기록하기 위한 변수 선언
    public static int[][] map = new int[50][50];
    // 북, 동, 남, 서 방향을 바라복 있을 때 이동 정의
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    /**
     * 왼쪽으로 회전 시
     * 동 ->  북, 남 -> 동, 서 -> 남, 북 -> 서
     * 즉 방향이 1씩 감소하게 됨
     */
    public static void turn_left() {
        d--;
        if (d == -1) d = 3;
    }

    public static void main(String[] args) {
        // n, m값 입력 받기
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();

        // 현재 좌표(x, y)와 바라보는 방향(d) 입력 받기
        x = sc.nextInt(); y = sc.nextInt(); d = sc.nextInt();
        // 현재 좌표 방문 처리
        visited[x][y] = 1;

        // 현재 맵 정보 입력 받기
        for(int i=0; i<n; i++)  {
            for(int j=0; j<m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // 시뮬레이션 시작
        int result = 1; // 현재 방문한 칸의 수 포함
        int turn_time = 0; // 회전한 횟수가 4번일 경우 뒤로 한 칸 이동해야 함

        while(true) {
            turn_left(); // 1단계 왼쪽으로 회전
            int nx = x + dx[d];
            int ny = y + dy[d];
            // 회전한 이후 정면에 가보지 않은 칸이 존재하면서 육지인 경우 이동
            if(visited[nx][ny] == 0 && map[nx][ny] == 0) {
                visited[nx][ny] = 1; // 이동한 칸을 방문했음 표시
                result++;
                x = nx;
                y = ny;
                turn_time = 0;
                continue;
            }
            else { // 회전한 이후 정면에 가본 칸이거나 바다인 경우
                turn_time++;
            }

            // 네 방향을모두 갈 수 없는 경우
            if(turn_time == 4) {
                nx = x - dx[d];
                ny = y - dy[d];
                // 뒤로 갈 수 있는 경우 (즉, 육지인 경우)
                if(map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    turn_time = 0;
                }
                else { // 뒤로 갈 수 없는 경우 종료
                    break;
                }
            }
        }

        System.out.println(result);
        sc.close();
    }
}
