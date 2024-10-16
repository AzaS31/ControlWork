import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Registry registry = new Registry();
        Scanner scanner = new Scanner(System.in);
        Counter counter = new Counter(); 
        boolean exit = false;

        while (!exit) {
            System.out.println("\n1. Add Animal");
            System.out.println("2. List Animals");
            System.out.println("3. View Animal Commands");
            System.out.println("4. Teach New Command");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addAnimalMenu(scanner, registry, counter);
                    break;
                case 2:
                    registry.listAnimals();
                    break;
                case 3:
                    viewCommandsMenu(scanner, registry);
                    break;
                case 4:
                    teachCommandMenu(scanner, registry);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
        counter.close(); 
    }

    private static void addAnimalMenu(Scanner scanner, Registry registry, Counter counter) {
        System.out.print("Enter animal name: ");
        String name = scanner.nextLine();
        System.out.print("Enter birthdate (YYYY-MM-DD): ");
        String birthDate = scanner.nextLine();

        System.out.println("Choose type of animal:");
        System.out.println("1. Domestic Animal (Dog, Cat, Hamster)");
        System.out.println("2. Pack Animal (Horse, Donkey)");
        int choice = scanner.nextInt();
        scanner.nextLine();  

        Animal animal;
        boolean validInput = !name.isEmpty() && !birthDate.isEmpty(); // Проверка заполненности полей

        if (validInput) {
            try {
                if (choice == 1) {  // Добавляем домашнее животное
                    System.out.print("Enter domestic animal type (Dog, Cat, Hamster, etc): ");
                    String petType = scanner.nextLine();
                    animal = new DomesticAnimal(name, birthDate, petType);
                    registry.addAnimal(animal);
                    counter.add(); // Увеличиваем счетчик
                } else if (choice == 2) {  // Добавляем вьючное животное
                    System.out.print("Enter pack animal type (Donkey, Horse, Camel, etc): ");
                    String packAnimalType = scanner.nextLine();
                    animal = new PackAnimal(name, birthDate, packAnimalType);
                    registry.addAnimal(animal);
                    counter.add(); // Увеличиваем счетчик
                } else {
                    System.out.println("Invalid choice. Animal not added.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Animal name and birthdate must be provided.");
        }
    }

    private static void viewCommandsMenu(Scanner scanner, Registry registry) {
        System.out.print("Enter animal name to view commands: ");
        String name = scanner.nextLine();
        Animal animal = registry.findAnimal(name);
        if (animal != null) {
            animal.printCommands();
        } else {
            System.out.println("Animal not found.");
        }
    }

    private static void teachCommandMenu(Scanner scanner, Registry registry) {
        System.out.print("Enter animal name to teach new command: ");
        String name = scanner.nextLine();
        Animal animal = registry.findAnimal(name);
        if (animal != null) {
            System.out.print("Enter new command: ");
            String command = scanner.nextLine();
            animal.addCommand(command);
            System.out.println("Command added.");
        } else {
            System.out.println("Animal not found.");
        }
    }
}
