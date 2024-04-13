/**
 * 
 */
package com.utility.model;

import org.springframework.stereotype.Component;

/**
 * 
 */
@Component
public class BmiInfo {
	
	private double weight;
	private double height;
	
	public BmiInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BmiInfo(double weight, double height) {
		super();
		this.weight = weight;
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "BmiInfo [weight=" + weight + ", height=" + height + "]";
	}
}
