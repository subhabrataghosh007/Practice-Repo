package misc;

import java.util.*;

public class SearchSuggestionsSystemBruteForce {
	
	public static void main(String[] args) {
		
		String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
		String searchWord = "mouse";
		
		SearchSuggestionsSystemBruteForce s = new SearchSuggestionsSystemBruteForce();
		
		Arrays.sort(products);
		System.out.println(s.suggestedProducts(products, searchWord));
		
	}
	
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		List<List<String>> res = new ArrayList<>();
		
		StringBuilder prefix = new StringBuilder();
		for (char c : searchWord.toCharArray()) {
			List<String> productList = getProducts(products, prefix.append(c).toString());
			res.add(productList);
		}
		return res;
	}
	
	private List<String> getProducts(String[] products, String search) {
		List<String> productList = new ArrayList<String>();
		
		for (String product : products) {
			if (product.startsWith(search))
				productList.add(product);
			if(productList.size() == 3)
				break;
		}
		return productList;
	}

}