package com.vdub.dspractice.graph;

public class Edge {
	private int src;
	private int dst;
	private int weight;

	public Edge(int src, int dst, int weight) {
		this.src = src;
		this.dst = dst;
		this.weight = weight;
	}


	public int getSrc() {
		return this.src;
	}

	public void setSrc(int src) {
		this.src = src;
	}

	public int getDst() {
		return this.dst;
	}

	public void setDst(int dst) {
		this.dst = dst;
	}

	public int getWeight() {
		return this.weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
