package test;

import java.io.Serializable;

public class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String age;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		if(null!=age && !age.equals("null") && Double.parseDouble(age)>1.0){
			System.out.print("ok");
		}
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "{" +
			"name='" + name + '\'' +
			", age='" + age + '\'' +
			'}';
	}
}
