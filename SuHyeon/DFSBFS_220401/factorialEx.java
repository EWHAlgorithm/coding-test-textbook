public class factorialEx {
    public static int factorial_iterative(int n) {
        int result = 1;

        if(n<0) {
            System.out.println("잘못된 입력값입니다.");
            return 0;
        } else if(n<=1) {
            return 1;
        }
        
        while(n>0) {
            result *= n;
            n--;
        }
        return result;
    }

    public static int factorial_recursive(int n) {
        if(n<0) {
            System.out.println("잘못된 입력값입니다.");
            return 0;
        } else if(n<=1) {
            return 1;
        } else{
            return n * factorial_recursive(n-1);
        }
    }

    public static void main(String[] args) {
        System.out.println("반복 구현: " + factorial_iterative(5));
        System.out.println("재귀 구현: " + factorial_recursive(5));
    }
    
}
