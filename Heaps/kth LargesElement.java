import java.util.*;
class kthLargesElement{

    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int kthLargest = findKthLargest(nums, k);
        System.out.println(kthLargest);
    }

    public static int findKthLargest(int[] nums, int k) 
	{
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums)
		{
            pq.offer(num);
            if (pq.size() > k) 
			{
                pq.poll();
            }
        }
        return pq.peek();}
    }
