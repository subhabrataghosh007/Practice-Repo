package misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentlyMentionedKeywords {

	public static void main(String[] args) {

		String[] keywords = { "anacell", "cetracular", "betacellular" };
		String[] reviews = { "Anacell provides the best services in the city", "betacellular has awesome services",
				"Best services provided by anacell, everyone should use anacell" };
		int k = 2;
		
//		String[] keywords = {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
//		String[] reviews = {"I love anacell Best services; Best services provided by anacell",
//				  "betacellular has great services",
//				  "deltacellular provides much better services than betacellular",
//				  "cetracular is worse than anacell",
//				  "Betacellular is better than deltacellular."};
//		int k = 2;
		

		TopKFrequentlyMentionedKeywords t = new TopKFrequentlyMentionedKeywords();
		System.out.println(t.topKFrequent(reviews, keywords, k));

	}

	public List<String> topKFrequent(String[] reviews, String[] keywords, int k) {

		Map<String, Integer> occurance = new HashMap<>();
		
		for (String s : keywords)
			occurance.put(s, 0);
		
		for (String review : reviews) {
			review = review.toLowerCase();
			String[] rs = review.split("\\W");
			
			for (String s : rs) {
				if (occurance.containsKey(s.toLowerCase())) {
					occurance.put(s, occurance.get(s)+1);
				}
			}
		}
		
		PriorityQueue<String> maxHeap = new PriorityQueue<>(
				(w1, w2) -> occurance.get(w1).equals(occurance.get(w2)) ? w2.compareTo(w1) : occurance.get(w2) - occurance.get(w1));
		
		for (String s : keywords)
			maxHeap.add(s);
		
		System.out.println(occurance);
		System.out.println(maxHeap);
		
		List<String> result = new ArrayList<>();
		while (!maxHeap.isEmpty() && k-- > 0)
			result.add(maxHeap.poll());
		
		return result;
	}
}
