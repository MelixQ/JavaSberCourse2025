package lr7;


import java.io.Serializable;

public class Lr7_Person implements Serializable {
	private final String name;
	private final int age;

	public Lr7_Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
