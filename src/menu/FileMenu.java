package menu;

import java.util.Scanner;

public enum FileMenu {
    WRITE, REWRITE, READ, SAVE, LOAD, EXIT;

    private static Scanner scanner = new Scanner(System.in);

    public static FileMenu getFileMenu() {
        try {
            System.out.println("Input at console : (WRITE) to Write ZooClub .txt, \n" +
                    "(REWRITE) to Rewrite ZooClub .txt,\n" +
                    "(READ) to Read ZooClub .txt,\n" +
                    "(SAVE) to Save ZooClub\n" +
                    "(LOAD) to Load ZooClub, (EXIT)");
            return FileMenu.valueOf(scanner.next().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Error, input command not found! Try again");
            System.out.println("_____________________");
        }
        return getFileMenu();
    }
}
