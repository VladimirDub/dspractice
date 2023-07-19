package com.vdub.dspractice;

public class SegmentTree {
	
	int[] tree;
	int[] nums;
	int size;

	SegmentTree(int[] nums) {
		this.size = nums.length;
		this.nums = nums;
		tree = new int[size * 2];
		for (int i = 0; i < size; i++) {
			tree[i + size] = nums[i];
		}
		for (int i = size - 1; i > 0; i--) {
			tree[i] = tree[i << 1] + tree[(i << 1) + 1];
		}
	}

	public void update(int idx, int val) {
		int diff = val - nums[idx];
		nums[idx] = val;
		int i = idx + size;
		while (i > 0) {
			tree[i] += diff;
			i >>= 1;
		}
	}

	public int sum(int start, int end) {
		int l = start + size;
		int r = end + size;
		int s = 0;
		while (l <= r) {
			if (l % 2 == 1) {
				s += tree[l];
				l += 1;
			}
			if (r % 2 == 0) {
				s += tree[r];
				r -= 1;
			}
			l >>= 1;
			r >>= 1;
		}
		return s;
	}

}
