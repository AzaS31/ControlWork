import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    private String name;
    private String birthDate;
    private List<String> commands;

    public Animal(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public void printCommands() {
        if (commands.isEmpty()) {
            System.out.println(name + " doesn't know any commands.");
        } else {
            System.out.println(name + " knows the following commands: " + String.join(", ", commands));
        }
    }

    public abstract void displayInfo();
}
