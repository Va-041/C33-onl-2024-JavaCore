package lesson15.homework.BasicTask;

import java.util.LinkedList;

public class AnimalCollection {

    private LinkedList<String> animals;

    public AnimalCollection() {
        animals = new LinkedList<>();
    }

    public void addAnimal(String animal) {
        animals.addFirst(animal);
    }

    public String removeAnimal() {
        if(!animals.isEmpty()) {
            return animals.removeLast();
        }
        return null;
    }

    public void displayAnimals() {
        System.out.println("Current animals: " + this.toString());
    }

    @Override
    public String toString() {
        if (animals.isEmpty()) {
            return "No animals in the collection.";
        }
        StringBuilder result = new StringBuilder();
        for (String animal : animals) {
            result.append(animal).append(", ");
        }
        //чтобы удалить последнюю запятую и пробел:
        result.setLength(result.length() - 2);
        return result.toString();
    }
}
