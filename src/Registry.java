import java.util.ArrayList;
import java.util.List;

public class Registry {
    private List<Animal> animals;

    public Registry() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println(animal.getName() + " has been added.");
    }

    public void listAnimals() {
        if (animals.isEmpty()) {
            System.out.println("No animals in the registry.");
        } else {
            for (Animal animal : animals) {
                animal.displayInfo();
            }
        }
    }

    public Animal findAnimal(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }
}
