package menu;

import java.util.Scanner;

public enum StartMenu {
    ADD, REMOVE, PRINT, FILE, EXIT;

    private static Scanner scanner = new Scanner(System.in);

    public static StartMenu getStartMenu() {
        try {
            System.out.println("Input at console : (ADD), (REMOVE), (PRINT), (FILE), (EXIT)");
            return StartMenu.valueOf(scanner.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Error, input command not found! Try again");
            System.out.println("_____________________");
        }
        return getStartMenu();
    }
}
