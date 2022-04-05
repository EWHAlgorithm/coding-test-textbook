import java.util.*;

public class LargeNum {
    public static void main(String[] args) throws Exception {
        int N, M, K, result = 0;
        Scanner sc = new Scanner(System.in);
        
        // N, M, K값 입력 받기
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        // N개의 수 저장할 변수 선언하고 입력받기
        int[] num = new int[N];
        for(int i=0; i<N; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);

        int maxNum = num[N-1];
        int max2nd = num[N-2];

        int cnt1 = M / (K+1); // 같은 합을 반복하는 횟수
        int cnt2 = M % (K+1); // 가장 큰 수가 추가되는 횟수

        result = (maxNum * K + max2nd) * cnt1 + maxNum * cnt2;

        System.out.println(result);
        sc.close();
        
    }
}