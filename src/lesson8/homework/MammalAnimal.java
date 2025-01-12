package lesson8.homework;

abstract class MammalAnimal extends Animal {
    boolean hasFur;

    public MammalAnimal(String name, String color, int age,String gender, boolean hasFur) {
        super(name, color, age, gender);
        this.hasFur = hasFur;
    }
}
