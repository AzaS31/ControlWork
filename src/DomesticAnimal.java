class DomesticAnimal extends Animal {
    private String petType;

    public DomesticAnimal(String name, String birthDate, String petType) {
        super(name, birthDate);
        this.petType = petType;
    }

    @Override
    public void displayInfo() {
        System.out.printf("Domestic Animal: %s, %s, Birthdate: %s%n", getName(), petType, getBirthDate());
    }
}