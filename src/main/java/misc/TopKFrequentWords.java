package misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {

	public static void main(String[] args) {

		String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
		//String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		
		int k = 4;
		TopKFrequentWords t = new TopKFrequentWords();
		
		System.out.println(t.topKFrequent(words, k));
	}

	public List<String> topKFrequent(String[] words, int k) {

		HashMap<String, Integer> count = new HashMap<>();
		
		for (String s : words) {
			count.put(s, count.getOrDefault(s, 0)+1);
		}
		
		System.out.println(count);
		
		PriorityQueue<String> heap = new PriorityQueue<>(
				(w1, w2) -> count.get(w1).equals(count.get(w2)) ? w1.compareTo(w2) : count.get(w2) - count.get(w1));
		
		for (String s : count.keySet()) {
			heap.offer(s);
		}
		
		System.out.println();
		System.out.println(heap);
		
		List<String> result = new ArrayList<>();
		while (!heap.isEmpty() && k-- > 0)
			result.add(heap.poll());
		
		//Collections.reverse(result);
		System.out.println();
		
		
		return result;
	}

}
