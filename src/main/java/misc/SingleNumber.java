package misc;

import java.util.HashMap;
import java.util.HashSet;

public class SingleNumber {

	public static void main(String[] args) {

		int[] nums = { 2, 2, 4, 3, 3 };

		System.out.println(new SingleNumber().singleNumber(nums));
	}

	public int singleNumber(int[] nums) {

		int num = 0;

		for (int i : nums)
			num = num ^ i;

		return num;
	}

	public int singleNumberUsingSet(int[] nums) {

		HashSet<Integer> set = new HashSet<>();

		for (int i : nums) {
			if (set.contains(i))
				set.remove(new Integer(i));
			else
				set.add(i);
		}

		for (int i : set)
			return i;

		return -1;
	}

}
