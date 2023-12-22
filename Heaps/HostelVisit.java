import java.util.*;
public class HostelVisit{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        int K = sc.nextInt();
        PriorityQueue<Long> distances = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < Q; i++) {
            int queryType = sc.nextInt();
            if (queryType == 1) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                long distance = (long) x * x + (long) y * y;
                distances.add(distance);
                if (distances.size() > K) {
                    distances.poll();
                }
            } else if (queryType == 2) {
                System.out.println(distances.peek());}}}}