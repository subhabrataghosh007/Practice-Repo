package misc;

import java.util.*;

public class ReorderDatainLogFiles {

	public static void main(String[] args) {

		// String[] logs = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit
		// dig", "let3 art zero" };
		String[] logs = { "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo" };

		ReorderDatainLogFiles files = new ReorderDatainLogFiles();

		String[] result = files.reorderLogFiles(logs);

		for (String string : result) {
			System.out.println(string);
		}
	}

	public String[] reorderLogFiles(String[] logs) {

		List<String> letterLogs = new ArrayList<>();
		List<String> digitLogs = new ArrayList<>();
		String[] result = new String[logs.length];

		for (String s : logs) {
			if (Character.isAlphabetic(s.charAt(s.length()-1)))
				letterLogs.add(s);
			else
				digitLogs.add(s);
		}

		letterLogs.sort((s1, s2) -> {
			String[] t1 = findSpaceSeperator(s1.toCharArray());
			String[] t2 = findSpaceSeperator(s2.toCharArray());

			String toIdentifier1 = t1[0];
			String toIdentifier2 = t2[0];

			String toSort1 = t1[1];
			String toSort2 = t2[1];

			return toSort1.equals(toSort2) ? toIdentifier1.compareTo(toIdentifier2) : toSort1.compareTo(toSort2);
		});

		int i = 0;
		for (String s : letterLogs)
			result[i++] = s;
		for (String s : digitLogs)
			result[i++] = s;

		return result;
	}

	String[] findSpaceSeperator(char[] c) {
		int i = 0;
		int l = c.length;
		for (i = 0; i < l; i++) {
			if (c[i] == ' ')
				break;
		}

		char[] s1 = new char[i];
		char[] s2 = new char[l - i];

		for (int j = 0; j < i; j++)
			s1[j] = c[j];
		for (int j = 0; j < l - i; j++)
			s2[j] = c[j + i];

		return new String[] { new String(s1), new String(s2) };
	}

//	public String[] reorderLogFiles(String[] logs) {
//
//		List<String> digitList = new ArrayList<>();
//		List<String> letterList = new ArrayList<>();
//		String[] res = new String[logs.length];
//
//		for (String s : logs) {
//			if (Character.isAlphabetic(s.charAt(s.length() - 1)))
//				letterList.add(s);
//			else
//				digitList.add(s);
//		}
//
//		
//		letterList.sort((s1, s2) -> {
//			
//			int a = s1.indexOf(" ");
//			int b = s2.indexOf(" ");
//			String temp1 = s1.substring(0, a);
//			String temp2 = s2.substring(0, b);
//
//			String toSort1 = s1.substring(a + 1);
//			String toSort2 = s2.substring(b + 1);
//			return toSort1.equals(toSort2) ? temp1.compareTo(temp2) : toSort1.compareTo(toSort2);
//		});
//
//		 int i = 0;
//		    for(String s : letterList) res[i++] = s;
//		    for(String s : digitList) res[i++] = s;
//
//		    return res;
//	}
//	
//	String[] findSpaceSeperator(char[] c) {
//		int i = 0;
//        int l = c.length;
//        for (i = 0; i < l; i++) {
//            if (c[i] == ' ')
//                break;
//        }
//        
//        char[] s1 = new char[i];
//        char[] s2 = new char[l-i];
//        
//        for (int j = 0; j < i; j++)  s1[j] = c[j];
//        for (int j = 0; j < l-i; j++) 
//        	s2[j] = c[j+i];
//        
//		return new String[] {new String(s1), new String(s2)};
//	}
}
