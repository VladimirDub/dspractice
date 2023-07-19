package com.vdub.dspractice;

import java.util.PriorityQueue;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class MinHeapTest {
	
	@Test 
	public void isEmpty() {
		MinHeap heap = new MinHeap(8);

		Assert.assertTrue(heap.isEmpty());
		heap.add(1);
		Assert.assertFalse(heap.isEmpty());
		heap.poll();
		Assert.assertTrue(heap.isEmpty());
	}

	@Test
	public void manual() {
		MinHeap heap = new MinHeap(8);

		heap.add(7);
		heap.add(5);
		heap.add(1);
		heap.add(4);
		heap.add(2);
		heap.add(3);
		heap.add(6);

		Assert.assertEquals(1, heap.poll());
		Assert.assertEquals(2, heap.poll());
		Assert.assertEquals(3, heap.poll());
		Assert.assertEquals(4, heap.poll());
		Assert.assertEquals(5, heap.poll());
		Assert.assertEquals(6, heap.poll());
		Assert.assertEquals(7, heap.poll());
	}

	@Test
	public void vsPriorityQueue() {
		int size = 100;
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		MinHeap heap = new MinHeap(size + 1);
		Random rnd = new Random();
		for (int i = size; i > 0; i--) {
			int x = rnd.nextInt(200) - 100;
			pQ.add(x);
			heap.add(x);
		}

		for (int i = size; i > 0; i--) {
			Assert.assertEquals(pQ.poll(), (Integer) heap.poll());
		}
	}

	@Test
	public void buildHeap() {
		int[] ar = { 7, 5, 1, 4, 2, 3, 6 };
		MinHeap heap0 = new MinHeap(8, ar);
		MinHeap heap1 = new MinHeap(8);

		for (int x : ar) {
			heap1.add(x);
		}

		while (!heap1.isEmpty()) {
			Assert.assertEquals(heap1.poll(), heap0.poll());
		}
	}
}
