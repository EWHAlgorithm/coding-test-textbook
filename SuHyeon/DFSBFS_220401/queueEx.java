import java.util.*;

public class queueEx {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        // 삽입
        q.offer(5);
        q.offer(2);
        q.offer(3);
        q.offer(7);

        // 삭제
        q.poll();

        q.offer(1);
        q.offer(4);

        q.poll();

        while(!q.isEmpty()) {
            System.out.print(q.poll() + " ");
        }
    }
}
