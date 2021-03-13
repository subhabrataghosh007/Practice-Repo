package misc;

import java.util.*;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public static void main(String[] args) {

		int[] nums = {1,1,1,2,2,3};
		int k =2;
		
		TopKFrequentElements t = new TopKFrequentElements();
		int[] result = t.topKFrequent(nums, k);
		
		for (int i : result)
			System.out.println(i);
	}

	public int[] topKFrequent(int[] nums, int k) {

		Map<Integer, Integer> occurance = new HashMap<>();

		for (int n : nums)
			occurance.put(n, occurance.getOrDefault(n, 0)+1);

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> occurance.get(n2) > occurance.get(n1) ? 1 : -1);

		for (int n : occurance.keySet())
			maxHeap.add(n);
		
		System.out.println(occurance);
		
		int[] result = new int[k];
		int i = 0;
		while (!maxHeap.isEmpty() && k-- > 0)
			result[i++] = maxHeap.poll();

		return result;
	}

}
