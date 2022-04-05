import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Change {
    public static void main(String[] args) throws Exception {
        int[] money = {500, 100, 50, 10};
        int n, count = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("거스름돈을 입력하세요: ");
        n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<money.length; i++) {
            count += (n / money[i]); // 가장 큰 화폐 단위부터 거슬러주기
            n %= money[i]; // 거스르고 남은 돈 업데이트
        }

        System.out.println("거슬러줘야 할 동전의 최소 개수는 " + count + "개입니다.");
    }
}