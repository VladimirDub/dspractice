package com.vdub.dspractice;

import org.junit.Assert;
import org.junit.Test;


public class IntervalTreeTest {

	@Test
	public void empty() {
		IntervalTree tree = new IntervalTree();
		Assert.assertEquals(0, tree.query(0, 100).size());
		Assert.assertFalse(tree.intersected(0, 100));
	}

	@Test
	public void singleInterval() {
		IntervalTree tree = new IntervalTree();
		tree.add(0, 100);

		Assert.assertEquals(1, tree.query(0, 10).size());
		Assert.assertTrue(tree.intersected(-5, 0));
		Assert.assertTrue(tree.intersected(0, 1));
		Assert.assertTrue(tree.intersected(50, 60));
		Assert.assertTrue(tree.intersected(99, 100));
		Assert.assertTrue(tree.intersected(100, 110));
		Assert.assertFalse(tree.intersected(-5, -1));
		Assert.assertFalse(tree.intersected(101, 110));
	}
	
	@Test
	public void nonOverlappingIntervals() {
		IntervalTree tree = new IntervalTree();
		tree.add(0, 100);
		tree.add(-300, -200);
		tree.add(200, 300);

		Assert.assertEquals(3, tree.query(-1000, 1000).size());
		Assert.assertEquals(0, tree.query(-50, -40).size());
		Assert.assertEquals(0, tree.query(110, 120).size());
		Assert.assertEquals(2, tree.query(-1000, 0).size());
	}

	@Test
 	public void overlappingIntervals() {
		IntervalTree tree = new IntervalTree();
		tree.add(0, 100);
		tree.add(-100, 10);
		tree.add(200, 300);

		Assert.assertEquals(2, tree.query(-1000, 1000).size());
		Assert.assertEquals(0, tree.query(-500, -400).size());
		Assert.assertEquals(0, tree.query(110, 120).size());
		Assert.assertEquals(1, tree.query(-1000, 0).size());
	}
 
}
