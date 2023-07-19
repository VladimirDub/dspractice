package com.vdub.dspractice;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class QuickSelectTest {
	
	@Test
	public void partition() {
		int size = 15;
		Random rnd = new Random();
		int[] ar = new int[size];
		for (int i = 0; i < size; i++) {
			ar[i] = rnd.nextInt(1000) - 500;
		}

		int x = QuickSelect.partition(ar, 0, size - 1);

		for (int i = 0; i < x; i++) {
			Assert.assertTrue(ar[i] < ar[x]);
		}
		for (int i = x + 1; i < size; i++) {
			Assert.assertTrue(ar[i] >= ar[x]);
		}

	}

	@Test
	public void quickselect() {
		int size = 10;
		int pos = 5;
		Random rnd = new Random();
		int[] ar = new int[size];
		for (int i = 0; i < size; i++) {
			ar[i] = rnd.nextInt(1000) - 500;
		}

		int x = QuickSelect.quickSelect(ar, pos);

		int count = 0;
		for (int i = 0; i < size; i++) {
			if (ar[i] < x) count++;
		}
		Assert.assertEquals(pos, count);
	}

}
