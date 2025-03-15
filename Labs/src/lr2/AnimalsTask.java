package lr2;

public class AnimalsTask {
	public static void main(String[] args) {
		Dog jack = new Dog("Джек", 3, "Немецкая овчарка");
		jack.getDistinctFeature();
		jack.produceSound();
		System.out.println();
		
		Cat lion = new Cat("Лёва", 5, "Хорошо видит в темноте");
		lion.getDistinctFeature();
		lion.produceSound();
		System.out.println();
		
		Bird birdy = new Bird("Пашка", 7, "Длинные перышки на голове", "Какаду");
		birdy.getDistinctFeature();
		birdy.produceSound();
	}
}

class Animal {
	protected String name;
	protected int age;
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void produceSound() {
		System.out.println("Звук животного");
	}
	
	public void getDistinctFeature() {
		System.out.println("Без особенностей");
	}
}

class Dog extends Animal {
	private String breed;
	
	public Dog(String name, int age, String breed) {
		super(name, age);
		this.breed = breed;
	}
	
	@Override
	public void produceSound() {
		System.out.println(name + " говорит: 'Гаф-гаф'");
	}
	
	@Override
	public void getDistinctFeature() {
		System.out.println(name + " - хороший мальчик породы " + breed.toLowerCase());
	}
}

class Cat extends Animal {
	private String feature; 
	
	public Cat(String name, int age, String feature) {
		super(name, age);
		this.feature = feature;
	}
	
	@Override
	public void produceSound() {
		System.out.println(name + " говорит: 'мяяу-у'");
	}
	
	@Override
	public void getDistinctFeature() {
		System.out.println(name + " - кошечка. Её особенность - " + feature.toLowerCase());
	}
}

class Bird extends Animal {
	private String feature;
	private String breed;
	
	public Bird(String name, int age, String feature, String breed) {
		super(name, age);
		this.feature = feature;
		this.breed = breed;
	}
	
	@Override
	public void produceSound() {
		System.out.println(name + " говорит: 'чик-чирик'");
	}
	
	@Override
	public void getDistinctFeature() {
		System.out.println(name + " - птичка " + breed.toLowerCase() + ". Её особенность - " + feature.toLowerCase());
	}
}
