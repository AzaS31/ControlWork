public class PackAnimal extends Animal {
    private String animalType;

    public PackAnimal(String name, String birthDate, String animalType) {
        super(name, birthDate);
        this.animalType = animalType;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Pack Animal: %s, %s, Birthdate: %s%n", getName(), animalType, getBirthDate());
    }
}