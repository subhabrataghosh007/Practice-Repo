package misc;

public class JumpGame {

	public static void main(String[] args) {

		 int[] nums = { 2, 3, 1, 1, 4 };
		//int[] nums = { 3, 2, 1, 0, 4 };

		System.out.println(new JumpGame().canJump(nums));
	}

	
	public boolean canJump(int[] nums) {

		int lastValidIndex = nums.length - 1;

		for (int i = nums.length - 1; i >= 0; i--) {
			if (i + nums[i] >= lastValidIndex) {
				lastValidIndex = i;
			} else
				break;
		}

		return lastValidIndex == 0;
	}
}
