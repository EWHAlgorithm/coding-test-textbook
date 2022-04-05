package Implementation;

/**
 * 비밀의 문을 열려고 살펴보니 특이한 형태의 자물쇠로 잠겨 있었고
 * 문 앞에는 특이한 형태의 열쇠와 함께 자물쇠를 푸는 방법에 대해 설명해주는 종이 발견됨
 * 
 * 잠겨있는 자물쇠는 한 칸의 크기가 1 x 1인 N x N 크기의 정사각 격자 형태
 * 특이한 모양의 열쇠는 M x M 크기의 정사각 격자 형태
 * 자물쇠에는 홈이 파여 있고 열쇠 또한 홈과 돌기 부분이 있다
 * 열쇠는 회전과 이동이 가능
 * 열쇠의 돌기 부분을 자물쇠의 홈 부분에 딱 맞게 채우면 열리게 되는 구조이다.
 * 
 * 자물쇠 영역 내에서 열쇠의 돌기 부분과 자물쇠의 홈 부분이 정확히 일치해야 성공
 * 이 때 열쇠의 돌기와 자물쇠의 돌기가 만나서는 안 됨
 * 또한 자물쇠의 모든 홈을 채워 비어있는 곳이 없어야 함
 */

public class Q10 {
    /**
     * 열쇠를 0도 90도 180도 270도 방향으로 회전하면서
     * 자물쇠의 (0, 0) 인덱스 부터 (len -1, len-1) 인덱스까지 겹치면서
     * 자물쇠와 열쇠가 맞는지 확인한다
     * 
     * for문을 돌리기 위해 자물쇠에 패딩을 넣어줘야 함
     * 열쇠가 자물쇠의 (0, 0)과 맞물릴 때부터
     * 자물쇠의 (len-1, len-1)과 맞물릴 때까지의 대각선 길이를 생각하면
     * (M - 1)  + N + (M - 1) = 2(M - 1) + N
     */

    // 열쇠 회전 함수
    private static int[][] rotate(int[][] key) {
        int[][] new_key = new int[key.length][key.length];

        // 시계방향으로 90도 회전
        for(int i=0; i<key.length; i++) {
            for(int j=0; j<key.length; j++) {
                new_key[i][j] = key[key.length-1-i][j];
            }
        }
        return new_key;
    }

    // 체킹 함수
    private static boolean check(int[][] check_lock, int m, int n) {
        /**
         * m은 열쇠의 크기
         * n은 자물쇠의 크기
         */
        for(int i=0; i<m+n-1; i++) {
            for(int j=0;j<m+n-1; j++){
                if(check_lock[i][j] != 1)
                    return false;
            }
        }
        return true;
    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int m = key.length;
        int n = key.length;

        // 자물쇠에 패딩 넣고 그 가운데에 자물쇠 넣어주기
        int[][] new_lock = new int[2*(m-1) + n][2*(m-1) + n];
        for(int i=0; i<n; i++)   {
            for(int j=0; j<n; j++) {
                new_lock[i+m-1][j+m-1] = lock[i][j];
            }
        }

        /**
         * * 새로운 자물쇠가 잘 패딩 되었는지 확인용 ==> 잘 됨!!
        for(int i=0; i<new_lock.length; i++) {
            for(int j=0; j<new_lock.length; j++) {
                System.out.print(new_lock[i][j]);
            }
            System.out.println();
        }
        */

        int[][] check_lock = new int[2*(m-1) + n][2*(m-1) + n];

        // 바깥 루프는 키 돌리기 (총 4번)
        int turn = 4;
        while(turn > 0) {
            // 열쇠가 오른쪽 or 아래로 이동하면서 자물쇠와 비교
            check_lock = new_lock;
            for(int i=0; i<m+n-1; i++) {
                for(int j=0; j<m+n-1; j++) {
                    // 만약 열쇠의 돌기(1)와 자물쇠의 돌기(1)가 맞물린 경우 false
                    // 만약 열쇠의 돌기(1)와 자물쇠의 홈(0)이 맞물린 경우 true
                    // ==> 합이 1이 되지 않는 칸이 있으면 false!!

                    // check_lock에 열쇠 추가하기
                    for(int r=0; r<m; r++) {
                        for(int c=0; c<m; c++) {
                            check_lock[i+r][j+c] += key[r][c];
                        }
                    }
                    // 모든 이동을 마친 후 check_lock의 모든 칸이 1인 경우 true가 됨
                    answer = check(check_lock, m, n);
                    if (answer) return true;
                }
            }
            rotate(key);
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(solution(key, lock));
    }
}
