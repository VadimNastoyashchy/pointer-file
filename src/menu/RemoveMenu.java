package menu;

import java.util.Scanner;

public enum RemoveMenu {
    PERSON, PET, PETS, EXIT;

    private static Scanner scanner = new Scanner(System.in);

    public static RemoveMenu getRemoveMenu() {
        try {
            System.out.println("Input at console : (PERSON) to Remove Person, (PET) to Remove pet, " +
                    "(PETS) to Remove all pets, (EXIT)");
            return RemoveMenu.valueOf(scanner.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Error, input command not found! Try again");
            System.out.println("_____________________");
        }
        return getRemoveMenu();
    }
}
