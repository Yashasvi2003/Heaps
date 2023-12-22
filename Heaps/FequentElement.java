import java.util.*;
 class FrequentElement {
    public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int testcases = scanner.nextInt();
		while(testcases-- > 0) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			int[] arr = new int[n];
			for(int i=0; i<n; i++)
				arr[i] = scanner.nextInt();

			printTopNo(arr, n, k);

		}
    }

	//main solution function
	private static void printTopNo(int[] arr, int n, int k) {
		PriorityQueue<Node> myHeap = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node one, Node two) {
				if(one.freq == two.freq) {
					return one.data - two.data;
				}

				return two.freq - one.freq;
			}
		});

		myHeap.offer(new Node(arr[0], 1));
		Map<Integer, Integer> dict = new HashMap<>();
		for(int i=0; i<n; i++) {
			if(dict.containsKey(arr[i])) {
				dict.put(arr[i], dict.get(arr[i]) + 1);
			}
else {
				dict.put(arr[i], 1);
			}
			
			insertInHeap(myHeap, dict);
			printHeap(myHeap, k);
		}
		System.out.println();
	}

	//function to insert into heap from HashMap
	private static void insertInHeap(PriorityQueue<Node> heap, Map<Integer, Integer> map) {
		heap.clear();
		for(int i: map.keySet())  {
			heap.offer(new Node(i, map.get(i)));
		}
	}

	//function to print the top k elements of the heap
	private static void printHeap(PriorityQueue<Node> q, int k) {
		while(!q.isEmpty() && k > 0) {
			System.out.print(q.poll() + " ");
			k--;
		}
	}

	//class to store the data and it's occurrence
private static class Node {
		int data;
		int freq;

		private Node(int data, int freq) {
			this.data = data;
			this.freq = freq;
		}

		@Override
		public String toString() {
			return "" + this.data;
		}
	}
}