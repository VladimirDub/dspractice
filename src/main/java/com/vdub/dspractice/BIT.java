package com.vdub.dspractice;

//Binary indexed tree implementation
public class BIT {

	int[] nums;
	int size;

	int[] bits;

	public BIT(int[] nums) {
		this.nums = nums;
		this.size = nums.length;
		this.bits = new int[size + 1];
		for (int i = 0; i < size; i++) {
			updateBIT(i + 1, nums[i]);
		}
	} 

	private void updateBIT(int i, int val) {
		while (i < size + 1) {
			bits[i] += val;
			i += i & -i;
		}
	}

	private int query(int i) {
		int sum = 0;
		while (i > 0) {
			sum += bits[i];
			i -= i & -i;
		}
		return sum;
	}

	public void update(int i, int val) {
		int prev = nums[i];
		int diff = val - prev;
		nums[i] = val;
		updateBIT(i + 1, diff);
	}

	public int sum(int start, int end) {
		return query(end + 1) - query(start);
	}
	
}
