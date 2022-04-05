package DFS_BFS;

public class RecursiveFinEx {
    public static void recursive_fin(int i) {
        if(i == 100) return;
        System.out.println(i + "번째 재귀 함수에서" + (i+1) + "번째 재귀 함수를 호출합니다.");
        recursive_fin(i + 1);
        System.out.println(i + "번째 재귀 함수를 종료합니다.");
    }
    public static void main(String[] args) {
        recursive_fin(1);
    }
}
