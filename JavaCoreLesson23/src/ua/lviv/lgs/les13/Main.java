package ua.lviv.lgs.les13;

import java.util.Scanner;

public class Main {
	static void menu() {
		System.out.println();
		System.out.println("Enter 1 to add a faction to the Verkhovna Rada");
		System.out.println("Enter 2 to remove a faction from the Verkhovna Rada");
		System.out.println("Enter 3 to remove all factions in the Verkhovna Rada");
		System.out.println("Enter 4 to clear the entered fraction");
		System.out.println("Enter 5 to display the entered fraction");
		System.out.println("Enter 6 to add a deputy to the faction");
		System.out.println("Enter 7 to remove a deputy from a faction");
		System.out.println("Enter 8 for a list of bribe-takers");
		System.out.println("Enter 9 for the biggest bribe taker");
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (true) {
			menu();
			switch (scanner.nextInt()) {

			case 1: {
				SupremeCouncil.getInstance().addDeputyGroup();
				break;
			}

			case 2: {
				SupremeCouncil.getInstance().removeDeputyGroup();
				break;
			}

			case 3: {
				SupremeCouncil.getInstance().getAllDeputyGroups();
				break;
			}

			case 4: {
				SupremeCouncil.getInstance().clearDeputyGroup();
				break;
			}

			case 5: {
				SupremeCouncil.getInstance().getDeputyGroup();
				break;
			}

			case 6: {
				SupremeCouncil.getInstance().addDeputyToDeputyGroup();
				break;
			}

			case 7: {
				SupremeCouncil.getInstance().removeDeputyFromDeputyGroup();
				break;
			}

			case 8: {
				SupremeCouncil.getInstance().getBribeTakersFromDeputyGroup();
				break;
			}

			case 9: {
				SupremeCouncil.getInstance().getLargestBribeTakerFromDeputyGroup();
				break;
			}
			default: {
				System.out.println("Please enter a number from 1 to 9!");
				break;
			}

			}

		}

	}
}
