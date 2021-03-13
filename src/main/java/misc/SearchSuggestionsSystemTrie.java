package misc;

import java.util.*;

public class SearchSuggestionsSystemTrie {
	
	public static void main(String[] args) {
		
		String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
		String searchWord = "mouse";
		
		SearchSuggestionsSystemTrie s = new SearchSuggestionsSystemTrie();
		
		System.out.println(s.suggestedProducts(products, searchWord));
		
	}
	
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		Arrays.sort(products);
		
		TrieNode root = build(products);
		
		List<List<String>> res = new ArrayList<>();
		
		for (char c : searchWord.toCharArray()) {
			if (root == null || root.next[c - 'a'] == null) {
				res.add(new ArrayList<>());
				root = null;
				continue;
			}
			root = root.next[c - 'a'];
			res.add(root.words);
		}
		return res;
	}

	private TrieNode build(String[] products) {
		TrieNode root = new TrieNode();
		for (String p : products) {
			TrieNode cur = root;
			for (char c : p.toCharArray()) {
				if (cur.next[c - 'a'] == null)
					cur.next[c - 'a'] = new TrieNode();
				cur = cur.next[c - 'a'];
				if (cur.words.size() < 3)
					cur.words.add(p);
			}
		}
		return root;
	}
}

class TrieNode {
	public TrieNode[] next;
	public List<String> words;

	public TrieNode() {
		next = new TrieNode[26];
		words = new ArrayList<>();
	}
}