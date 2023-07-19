package com.vdub.dspractice;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;

public class BITTest {
	
	@Test(expected = Exception.class)
	public void empty() {
		int[] nums = new int[0];
		BIT bit = new BIT(nums);
		bit.update(0, 0);
	}

	@Test
	public void singleElement() {
		int[] nums = { 1 }; 
		BIT bit = new BIT(nums);
		Assert.assertEquals(1, bit.sum(0, 0));
		bit.update(0, 5);
		Assert.assertEquals(5, bit.sum(0, 0));
	}

	@Test
	public void sumsOf1() {
		int size = 10;
		int[] nums = new int[size];
		Arrays.fill(nums, 1);
		BIT bit = new BIT(nums);
		for (int i = 0; i < size; i++) {
			Assert.assertEquals(i + 1, bit.sum(0, i));
		} 
	}

	@Test
	public void compareToLinearSum() {
		Random rnd = new Random();
		int size = rnd.nextInt(100) + 10;
		int[] nums = new int[size];
		for (int i = 0; i < size; i++) {
			nums[i] = rnd.nextInt(10000) - 10000;
		}
		BIT bit = new BIT(nums);

		Assert.assertEquals(sum(nums, 0, 0), bit.sum(0, 0));
		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				Assert.assertEquals(sum(nums, i, j), bit.sum(i, j));
			}
		}
	}
	
	private int sum(int[] nums, int start, int end) {
		int s = 0;
		for (int i = start; i <= end; i++) {
			s += nums[i];
		}
		return  s;
	}

}
