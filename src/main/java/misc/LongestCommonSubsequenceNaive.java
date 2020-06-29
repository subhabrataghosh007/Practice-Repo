package misc;

public class LongestCommonSubsequenceNaive {

	public static void main(String[] args) {

		String s1 = "OldSite:GeeksforGeeks.org";
		String s2 = "NewSite:GeeksQuiz.com";
		
		int max = 0;

		for (int i = 0; i < s1.length(); i++) {
			for (int j = i+1; j < s1.length(); j++) {
				String s3 = s1.substring(i, j);
				
				if (s2.contains(s3) && s3.length() > max) {
					max = s3.length();
				}
			}
		}
		
		System.out.println(max);
	}

}
