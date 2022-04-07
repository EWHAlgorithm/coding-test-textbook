package DFSBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ18352 {
    public static int N,M,K,X;

    public static int distance[] = new int[300001];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.add(x);

        while(!q.isEmpty()){
            int temp = q.poll();

            for(int i =0; i<graph.get(temp).size(); i++){
                int next = graph.get(temp).get(i);

                if(distance[next] == -1){
                    distance[next] = distance[temp] + 1;
                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); //도시 개수
        M = sc.nextInt(); //도로 개수
        K = sc.nextInt(); //최단 거리 정보
        X = sc.nextInt(); //출발 도시 번호

        distance[X] = 0;

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
            distance[i] = -1;
        }

        for(int i=0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            sc.nextLine();

            graph.get(a).add(b);
        }

        bfs(X);

        boolean yesOrNo = false;
        for(int i=0; i<=N; i++){
            if(distance[i] == K){
                System.out.println(i);
                yesOrNo = true;
            }
        }

        if(!yesOrNo)
            System.out.println(-1);

    }
}
