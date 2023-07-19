package com.vdub.dspractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IntervalTree {

	public static class Interval {
		private int left;
		private int right;

		Interval(int l, int r) {
			left = l;
			right = r;
		}

		int getLeft() { return left; }
		int getRight() { return right; }
		int getMid() { return (left + right) / 2; }
		void merge(Interval i) {
			if (i.getLeft() > right || i.getRight() < left) throw new RuntimeException();
			left = Math.min(left, i.getLeft());
			right = Math.max(right, i.getRight());
		}

		boolean intersected(int start, int end) {
			return 
			(start <= left && end >= left) || 
			(start <= right && end >= right) ||
			(start >= left && end <= right);
		}
	}

	static class IntervalNode {
		Interval interval;
		IntervalNode lNode;
		IntervalNode rNode;

		IntervalNode(Interval interval) {
			this.interval = interval;
		}

		void add(Interval i) {
			if (i.getRight() < interval.getMid()) {
				if (lNode == null) {
					lNode = new IntervalNode(i);
				} else {
					lNode.add(i);
				}
			} else if (i.getLeft() > interval.getMid()) {
				if (rNode == null) {
					rNode = new IntervalNode(i);
				} else {
					rNode.add(i);
				}
			} else {
				interval.merge(i);
			}	
		}

		private List<Interval> query(int start, int end, List<Interval> acc) {
			if (lNode != null) lNode.query(start, end, acc);
			if (interval.intersected(start, end)) {
				Interval clone = new Interval(interval.getLeft(), interval.getRight());
				if (acc.size() > 0 && acc.get(acc.size() - 1).getRight() >= interval.getLeft()) {
					acc.get(acc.size() - 1).merge(clone);
				} else {
					acc.add(clone);
				}
			}
			if (rNode != null) rNode.query(start, end, acc);
			return acc;
		}

		private boolean intersected(int start, int end) {
			if (interval.intersected(start, end)) return true;
			if (end < interval.left) {
				return lNode != null && lNode.intersected(start, end);
			} else {
				return rNode != null && rNode.intersected(start, end);
			}
		}
	}

	private IntervalNode root;

	public IntervalTree() {}

	public IntervalTree(List<Interval> intervals) {
		Collections.sort(intervals, Comparator.comparing(Interval::getLeft));
		add(intervals, 0, intervals.size() - 1);
	} 

	private void add(List<Interval> intervals, int start, int end) {
		if (end < start) return;
		int mid = (start + end / 2);
		add(intervals.get(mid));
		add(intervals, start, mid - 1);
		add(intervals, mid + 1, end);
	} 

	void add(Interval interval) {
		if (root == null) {
			root = new IntervalNode(interval);
		} else {
			root.add(interval);
		}
	}

	void add(int start, int end) {
		add(new Interval(start, end));
	}

	List<Interval> query(int start, int end) {
		if (root == null) return Collections.emptyList();
		return root.query(start, end, new ArrayList<>());
	}

	boolean intersected(int start, int end) {
		if (root == null) return false;
		return root.intersected(start, end);
	}
	
}
