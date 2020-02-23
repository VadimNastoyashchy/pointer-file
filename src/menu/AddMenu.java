package menu;

import java.util.Scanner;

public enum AddMenu {
    PERSON, PET, EXIT;

    private static Scanner scanner = new Scanner(System.in);

    public static AddMenu getAddMenu() {
        try {
            System.out.println("Input at console : (PERSON) to Add new Person, " +
                    "(PET) to Add new pet, (EXIT)");
            return AddMenu.valueOf(scanner.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Error, input command not found! Try again");
            System.out.println("_____________________");
        }
        return getAddMenu();
    }
}
