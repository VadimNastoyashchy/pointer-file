package src;

import menu.AddMenu;
import menu.FileMenu;
import menu.RemoveMenu;
import menu.StartMenu;

import java.io.*;
import java.util.*;

public class ZooClub implements Serializable {
    private static final long serialVersionUID = 2;
    private Map<Person, List<Pet>> map;
    private List<Pet> petList;
    Scanner scanner = new Scanner(System.in);

    public ZooClub() {
        this.map = new HashMap<>();
    }

    public Map<Person, List<Pet>> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "ZooClub{" +
                "map=" + map +
                '}';
    }

    public void startProgram() {
        System.out.println("_______________________________________________\n" +
                "ZooClub application. ver 2.0 (with save/loading)\n" +
                "Loading… ███████] 99%\n" +
                "_______________________________________________");

        while (true) {
            switch (StartMenu.getStartMenu()) {
                case ADD:
                    switch (AddMenu.getAddMenu()) {
                        case PET: {
                            System.out.println("Input Person name, to whom you want to add:");
                            addPetToPerson(new src.Person(scanner.next()));
                            break;
                        }
                        case PERSON: {
                            System.out.println("Input Person name:");
                            addPerson(new src.Person(scanner.next()));
                            break;
                        }
                        case EXIT: {
                            break;
                        }
                    }
                    break;
                case REMOVE:
                    switch (RemoveMenu.getRemoveMenu()) {
                        case PET:
                            System.out.println("Input Person name:");
                            removePetFromPerson(new src.Person(scanner.next()));
                            break;
                        case PERSON:
                            System.out.println("Input Person name:");
                            removePerson(new src.Person(scanner.next()));
                            break;
                        case PETS:
                            System.out.println("Input Pet Name:");
                            removePetFromAllPerson(new src.Pet(scanner.next()));
                            break;
                        case EXIT:
                            break;
                    }
                    break;
                case PRINT:
                    printZooClub();
                    break;
                case FILE:
                    switch (FileMenu.getFileMenu()) {
                        case WRITE:
                            writeZooClubToTxt(new File("C://ZooClub.txt"));
                        case REWRITE:
                            reWrite(new File("C://ZooClub.txt"));
                        case READ:
                            read(new File("C://ZooClub.txt"));
                        case SAVE:
                            saveObj(new File("C://ZooClub.zcs"));
                        case LOAD:
                            loadObj(new File("C://ZooClub.zcs"));
                        case EXIT:
                            break;
                    }
                    break;
                case EXIT:
                    System.out.println("Exit...........");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error 3. Wrong command!");
            }
        }
    }

    public void addPerson(Person person) {
        if (map.containsKey(person)) {
            System.out.println("Error 1. This Person already exists!\n" +
                    "_____________________");
        } else {
            map.put(person, new ArrayList<>());
            System.out.println("New Person created!\n" +
                    "_____________________");
        }
    }

    public void addPetToPerson(Person person) {
        if (map.containsKey(person)) {
            System.out.println("Input Pet Name:");
            map.get(person).add(new Pet(scanner.next()));
            System.out.println("New Pet created!\n" +
                    "_____________________");
        } else {
            System.out.println("Error 2. Enter Person not found!\n" +
                    "_____________________");
        }
    }

    public void removePetFromPerson(Person person) {
        if (map.containsKey(person)) {
            System.out.println("Input Pet Name:");
            map.get(person).remove(new Pet(scanner.next()));
            System.out.println("Your Pet remove!\n" +
                    "_____________________");
        } else {
            System.out.println("Error 2. Enter Person not found!\n" +
                    "_____________________");
        }
    }

    public void removePerson(Person person) {
        if (map.containsKey(person)) {
            map.remove(person);
        } else {
            System.out.println("Error 2. Enter Person not found!\n" +
                    "_____________________");
        }
    }

    public void removePetFromAllPerson(Pet pet) {
        for (Map.Entry<Person, List<Pet>> entry : map.entrySet()) {
            entry.getValue().remove(pet);
        }
    }

    public void printZooClub() {
        System.out.println(getMap());
    }

    public void writeZooClubToTxt(File file) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(getMap().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reWrite(File file) {
        if (file.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.write(getMap().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else System.out.println("Error file not found");
    }

    public void read(File file) {
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String fileRead = br.readLine();
                System.out.println(fileRead);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else System.out.println("Error file not found");
    }

    public void saveObj(File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadObj(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            ZooClub zooClubLoadVersion = (ZooClub) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}

