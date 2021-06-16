package ua.lviv.lgs.les13;

import java.util.Scanner;
import java.util.function.Supplier;

public class Deputy extends Human {
	private String surname;
	private String name;
	private int age;
	private boolean bribeTaker;
	private int bribeSize;
	
	
	public Deputy(float weight, float height, String surname, String name, int age, boolean bribeTaker) {
		super(weight, height);
		this.surname = surname;
		this.name = name;
		this.age = age;
		this.bribeTaker = bribeTaker;
	}



	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBribeTaker() {
		return bribeTaker;
	}

	public void setBribeTaker(boolean bribeTaker) {
		this.bribeTaker = bribeTaker;
	}

	public int getBribeSize() {
		return bribeSize;
	}

	public void setBribeSize(int bribeSize) {
		this.bribeSize = bribeSize;
	}

	void takeBrible() {

		if (!bribeTaker) {
			System.out.println("This deputy does not take bribes!");
		} else {
			System.out.println("Enter the bribe amount:");
			Scanner scanner = new Scanner(System.in);
			double temp = 0;
			try {
				temp = scanner.nextDouble();
				this.bribeSize += temp;
			} catch (IllegalArgumentException exception) {
				System.out.println(exception.getMessage());
			}
			if (temp > 5000) {
				System.out.println("The police will put the deputy in jail.");
			}

		}

	}

	Supplier<Integer> getBribeSize = () -> {
		Scanner scanner = new Scanner(System.in);
		int bribeSize = scanner.nextInt();

		return bribeSize;
	};

	@Override
	public String toString() {
		return "Deputy: Surname - " + surname + ", Name -" + name + ", Age - " + age + ", bribeTaker -" + bribeTaker
				+ ", bribeSize - " + bribeSize;
	}

}
