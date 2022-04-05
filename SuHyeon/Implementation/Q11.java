package Implementation;

import java.util.Scanner;

public class Q11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt(), apple_count = sc.nextInt();

        // R D L U 순서대로 이동 방향 정의
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};

        // 사과가 있는 칸은 1로 없는 칸은 0으로 설정
        int[][] map = new int[size][size];
        for(int i=0; i<apple_count; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x-1][y-1] = 1;
        }

        int l = sc.nextInt(); // 방향 변환 횟수 입력 받기
        // 방향 변환 횟수 만큼의 배열 선언
        int[] turn_time = new int[l];
        String[] direction = new String[l];

        for(int i=0; i<l; i++) {
            turn_time[i] = sc.nextInt();
            direction[i] = sc.next();
        }
        sc.close();

        // 시뮬레이션 시작
        int x = 1, y = 1; // 시작할 때 뱀의 위치
        map[x][y] = 2; // 뱀이 위치한 곳 2로 표시
        int d = 0; // 시작할 때 뱀의 이동 방향 (오른쪽)
        
        // int time = 0, snake_len = 1;
        while(true) {
            // 오른쪽부터 이동 시작
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 벽에 부딪히거나 자신의 몸과 부딪힌 경우
            if(map[nx][ny] == 1) {
                // snake_len++;
            }
            // 다음 칸에 사과가 없는 경우
        }
    }
}
