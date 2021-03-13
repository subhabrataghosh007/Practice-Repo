package misc;

import java.util.*;

public class PartitionLabels {

	public static void main(String[] args) {

		String S = "ababcbacadefegdehijhklij";
		PartitionLabels p = new PartitionLabels();

		System.out.println(p.partitionLabels(S));

	}

	public List<Integer> partitionLabels(String S) {

		List<Integer> result = new ArrayList<>();

		Map<Character, Integer> highest = new HashMap<>();

		for (int i = 0; i < S.length(); i++)
			highest.put(S.charAt(i), i);

		// System.out.println(highest);

		int i = 0;
		while (i < S.length()) {
			int end = highest.get(S.charAt(i));

			int j = i;
			while (j != end) {
				end = Math.max(end, highest.get(S.charAt(j++)));
			}
			result.add(j - i + 1);
			i = j + 1;
		}

		return result;
	}

	public List<Integer> partitionLabelsUsingArray(String S) {

		List<Integer> result = new ArrayList<>();
		int[] highest = new int[26];

		for (int i = 0; i < S.length(); i++)
			highest[S.charAt(i) - 'a'] = i;

		int i = 0;
		while (i < S.length()) {
			int end = highest[S.charAt(i) - 'a'];

			int j = i;
			while (j != end) {
				end = Math.max(end, highest[S.charAt(j++) - 'a']);
			}
			result.add(j - i + 1);
			i = j + 1;
		}

		return result;
	}
}
