package com.ssi;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private int rno;
	private String sname;
	private String branch;
	private int marks;
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Student(int rno, String sname, String branch, long contact) {
		super();
		this.rno = rno;
		this.sname = sname;
		this.branch = branch;
		this.marks = marks;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int rno) {
		super();
		this.rno = rno;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [rno=" + rno + ", sname=" + sname + ", branch="
				+ branch + ", contact=" + marks + "]";
	}
	
}
