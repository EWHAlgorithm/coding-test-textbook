package SuHyeon;

import java.util.Scanner;

/**
 * UpDownLeftRight
 */
public class UpDownLeftRight {

    public static void main(String[] args) {
        // 초기 좌표
        int x = 1, y = 1;

        // 정사각형 크기 입력 받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // \n 처리 - 정수 입력 받으면서 한꺼번에 처리하는 방법 없나...?

        // 계획서 입력받기
        String st = sc.nextLine();
        String[] plans = st.split(" ");

        for(String plan : plans) {
            int nx = x, ny = y;

            // 계획에 따라 이동해 준다
            switch (plan) {
                case "U":
                    nx -= 1;
                    break;
                case "D":
                    nx += 1;
                    break;
                case "L":
                    ny -= 1;
                    break;
                case "R":
                    ny += 1;
                    break;
                default:
                    break;
            }

            // 공간 밖을 벗어날 경우 스킵
            if(nx < 1 || ny < 1 || nx > n || ny > n){
                continue;
            }
            else { // 아닐 경우 반영
                x = nx;
                y = ny;
            }
        }
        
        System.out.println(x + " " + y);
        sc.close();
    }
}