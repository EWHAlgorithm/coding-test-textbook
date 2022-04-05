import java.util.*;

public class Q06 {
    public static void main(String[] args) {
        int[] food_times = {3, 1, 2};
        Solution sl = new Solution();
        System.out.println(sl.solution(food_times, 5));
    }
}

// 각 음식의 시간과 인덱스 저장할 객체 정의
class Food implements Comparable<Food> {
    private int time;
    private int index;

    public Food(int time, int index) {
        this.time = time;
        this.index = index;
    }

    public int getTime() {
        return this.time;
    }

    public int getIndex() {
        return this.index;
    }

    // 시간이 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Food other) {
        return Integer.compare(this.time, other.time);
    }
}

class Solution {
    public int solution(int[] food_times, long k) {
        // 전체 음식을 다 먹는 시간이 k보다 작거나 같다면 경우 -1 반환
        long total_time = 0;
        long len = food_times.length;
        for(int i=0; i<len; i++) {
            total_time += food_times[i];
        }
        if(total_time <= k) return -1;

        // 시간이 작은 음식부터 빼야 하므로 우선순위 큐를 이용
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for(int i=0; i<len; i++) {
            // (음식 시간, 음식 번호) 형태로 우선순위 큐에 삽입
            pq.offer(new Food(food_times[i], i+1));
        }

        total_time = 0; // 먹기 위해 사용한 시간
        long previous = 0; // 직전에 다 먹은 음식 시간

        // total_time + (현재 음식 시간 - 이전 음식 시간) * 현재 음식 개수와 k 비교
        while(total_time + ((pq.peek().getTime() - previous) * len) <= k) {
            
        }
        
        int answer = 0;
        return answer;
    }
}