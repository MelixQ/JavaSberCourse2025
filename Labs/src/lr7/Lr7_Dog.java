package lr7;


import java.io.Serializable;

public class Lr7_Dog implements Serializable {
	private final String nickname;
	private final String breed;
	private final int age;

	public Lr7_Dog(String nickname, String breed, int age) {
		this.nickname = nickname;
		this.breed = breed;
		this.age = age;
	}

	public String getNickname() {
		return nickname;
	}
	public String getBreed() { return breed; }
	public int getAge() {
		return age;
	}
}
