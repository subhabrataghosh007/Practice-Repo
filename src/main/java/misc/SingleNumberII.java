package misc;

import java.util.HashMap;

public class SingleNumberII {

	public static void main(String[] args) {
		int[] nums = { 2, 1, 2, 1, 2, 9, 1 };
		
		
		System.out.println(new SingleNumberII().singleNumber(nums));
	}

	public int singleNumber(int[] nums) {

		int ones = 0, twos = 0, not_three = 0;
		
		for (int num : nums) {
			
			twos = twos | (ones & num);
			ones = ones ^ num;
			
			not_three = ~ (twos & ones);
			
			ones = ones & not_three;
			twos = twos & not_three;
		}
		
		return ones;

	}

	public int singleNumberHashMap(int[] nums) {

		int num = 0;

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
			if (map.get(n) == 3)
				map.remove(n);
		}

		System.out.println(map);
		for (int i : map.keySet())
			return i;

		return 0;
	}

}
