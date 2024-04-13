package com.utility.model;

import org.springframework.stereotype.Component;

@Component
public class BmrInfo {
	
	private double weight;
	private double height;
	private String gender;
	private int age;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "BmrInfo [weight=" + weight + ", height=" + height + ", gender=" + gender + ", age=" + age + "]";
	}
	public BmrInfo(double weight, double height, String gender, int age) {
		super();
		this.weight = weight;
		this.height = height;
		this.gender = gender;
		this.age = age;
	}
	public BmrInfo() {
		super();
	}
}
