package DFS_BFS;
import java.util.Scanner;

public class icecream {
    public static int n, m;
    public static int[][] frame = new int[1000][1000];
    public static int result = 0;

    // dfs 구현 (행, 열이 파라미터로 전달됨)
    public static boolean dfs(int x, int y) {
        // x>n, y>m인 경우로 했더니 결과값 다르게 나옴 왜...?
        if(x<0 || y<0 || x>=n || y>=m) return false;

        // 뚫려있는 경우
        if(frame[x][y] == 0) {
            frame[x][y] = 1; // 방문 처리
            dfs(x-1, y); // 상
            dfs(x+1, y); // 하
            dfs(x, y-1); // 좌
            dfs(x, y+1); // 우 탐색
            return true;
        }

        return false;

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); // 빈 줄 처리

        // 틀 입력받기
        for(int i=0; i<n; i++) {
            String line = sc.nextLine();
            for(int j=0; j<m; j++) {
                frame[i][j] = line.charAt(j) - '0';
            }
        }
        /**
         * 탐색하면서 0은 방문 체크를 해주고
         * 0인 묶음 내에 있는 경우 true 반환해주며 result++
         * 이 과정 반복
         */
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                boolean flag = dfs(i,j);
                if(flag) result++;
            }
        }
        System.out.println(result);
        sc.close();
    }
}
