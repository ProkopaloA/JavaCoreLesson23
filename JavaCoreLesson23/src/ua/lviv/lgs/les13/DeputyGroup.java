package ua.lviv.lgs.les13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class DeputyGroup {

	private String deputyGroupName;

	public DeputyGroup(String deputyGroupName) {
		this.deputyGroupName = deputyGroupName;
	}

	public String getDeputyGroupName() {
		return deputyGroupName;
	}

	public void setDeputyGroupName(String deputyGroupName) {
		this.deputyGroupName = deputyGroupName;
	}

	List<Deputy> DeputyList = new ArrayList<>();

	Supplier<Deputy> createDeputy = () -> {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the surname of the deputy:");
		String surname = scanner.next();
		System.out.println("Enter the name of the deputy:");
		String name = scanner.next();
		System.out.println("Enter the age of the deputy:");
		int age = scanner.nextInt();
		System.out.println("Enter the height of the deputy:");
		float height = scanner.nextInt();
		System.out.println("Enter Deputy weight:");
		float weight = scanner.nextInt();
		System.out.println("Does the deputy take bribes (true/false):");
		boolean bribeTaker = scanner.nextBoolean();

		return new Deputy(weight, height, surname, name, age, bribeTaker);
	};

	private Deputy i;


	public void addDeputy() {
		Deputy deputy = createDeputy.get();
		DeputyList.add(deputy);
	}

	Supplier<Deputy> getDeputy = () -> {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the surname of the deputy:");
		String surname = scanner.next();
		System.out.println("Enter the name of the deputy:");
		String name = scanner.next();
		Predicate<Deputy> isEqualSurnameName = deputy-> deputy.getSurname().equalsIgnoreCase(surname)&& deputy.getName().equalsIgnoreCase(name);
		Optional<Deputy> deputyFound = DeputyList.stream().filter(isEqualSurnameName).findFirst();
		return i;
	};

	public void removeDeputy() {
		if (DeputyList.isEmpty()) {
			System.out.println("There are no deputies in your faction yet! Add them first! ");
		} else {
			Deputy DP = getDeputy.get();
			Predicate<Deputy> isEqualSurnameName = deputy -> deputy.getSurname().equalsIgnoreCase(DP.getSurname())
					&& deputy.getName().equalsIgnoreCase(DP.getName());
			Optional<Deputy> deputyFound = DeputyList.stream().filter(isEqualSurnameName).findFirst();
			if (deputyFound.isPresent()) {
				DeputyList.remove(deputyFound.get());
				System.out.println("Deputy " + deputyFound.get().toString() + " successfully removed from faction!");
			} else {
				System.out.println("The entered deputy does not exist!");
			}

		}
	}

	public void BribeTakers() {
		System.out.println("Members of the faction who take bribes: ");
		List<Deputy> bribeTakers = DeputyList.stream().filter(Deputy::isBribeTaker).collect(Collectors.toList());
		bribeTakers.forEach(System.out::println);
	}

	public void LargestBribeTaker() {
		Comparator<Deputy> deputyBribeSizeComparator = (deputy1,
				deputy2) -> (deputy1.getBribeSize() > deputy2.getBribeSize()) ? 1
						: (deputy1.getBribeSize() == deputy2.getBribeSize()) ? 0 : -1;
		Optional<Deputy> largestBribeTaker = DeputyList.stream().filter(Deputy::isBribeTaker)
				.max(deputyBribeSizeComparator);

		if (largestBribeTaker.isPresent()) {
			System.out.println("The biggest bribe-taker of the faction " +largestBribeTaker.get().toString());}
		 else {
			System.out.println("There are no bribe-takers in this batch!");
		}
	}

	public void AllDeputies() {
		System.out.println("Members of this faction:");
		DeputyList.forEach(System.out::println);
	}

	public void clearDeputyGroup() {
		DeputyList.clear();
		System.out.println("Faction is empty!");
	}

	@Override
	public String toString() {
		return "DeputyGroup - nameOfdeputyGroup " + deputyGroupName + ", DeputyList: " + DeputyList;
	}

}
