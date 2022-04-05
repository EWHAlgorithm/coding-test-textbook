import java.util.*;

public class Q01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 모험가의 수 입력받기

        // 모험가의 공포도 값 입력받기
        int[] scared = new int[n];
        for(int i=0; i<scared.length; i++) {
            scared[i] = sc.nextInt();
        }
        Arrays.sort(scared);

        int result = 0;
        int index = 0;
        while(true) {
            index += scared[index]; // 공포도의 수 만큼의 인원을 배열에서 건너 뛰어줌
            // 건너 뛴 후의 인덱스가 배열 범위를 벗어났을 경우 그룹 생성 종료
            if(index >= n)
                break;
            else
                result++;
        }

        System.out.println(result);
        sc.close();
    }
}
