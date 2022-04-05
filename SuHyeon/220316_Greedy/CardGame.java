import java.util.*;

public class CardGame {
    public static void main(String[] args) {
        int n, m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();

        // 한 행의 카드 값을 배열에 저장
        int[] arr = new int[m];
        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // 배열 크기순으로 정렬한 후 뽑을 카드 값 초기화
        Arrays.sort(arr);
        int cardNum = arr[0];
        n--;

        while(n>0){
            // 한 행의 카드 값을 배열에 업데이트
            arr = new int[m];
            for(int i=0; i<arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            // 배열 크기순으로 정렬한 후 뽑을 카드 값 업데이트
            Arrays.sort(arr);
            cardNum = (cardNum < arr[0]) ? arr[0] : cardNum;
            n--;
        }

        System.out.println(cardNum);
        sc.close();
    }
}
