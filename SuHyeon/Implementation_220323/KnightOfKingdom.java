package SuHyeon;

import java.util.Scanner;

public class KnightOfKingdom {
    public static void main(String[] args) {
        // 현재 위치 좌표로 변환하기
        Scanner sc = new Scanner(System.in);
        String position = sc.next();
        int col = position.charAt(0) - 'a' + 1;
        int row = position.charAt(1) - '0';

        int result = 0;

        // 나이트가 이동할 수 있는 모든 방향
        int[] canMove_x = {1, -1, 2, 2, 1, -1, -2, -2};
        int[] canMove_y = {2, 2, 1, -1, -2, -2, 1, -1};

        // 모든 방향을 이동해보며 정원 밖이 아닐 경우 result 추가해주기
        for(int i=0; i<8; i++) {
            int nx = col + canMove_x[i];
            int ny = row + canMove_y[i];

            if(nx < 1 || ny < 1 || nx > 8 || ny > 8) {
                continue;
            }
            else {
                result++;
            }
        }

        System.out.println(result);
        sc.close();
    }
}