package ru.deevaaleksandra.animals_streams;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("lion", 5));
        animals.add(new Animal("tiger", 3));
        animals.add(new Animal("giraffe", 1));
        animals.add(new Animal("rhinoceros", 7));
        animals.add(new Animal("hippopotamus", 4));
        animals.add(new Animal("elephant", 10));
        animals.add(new Animal("zebra", 9));
        animals.add(new Animal("antelope", 2));
        animals.add(new Animal("monkey", 8));
        animals.add(new Animal("alligator", 6));

//        isLionHere(animals);
//        animalsSort(animals);
//        adultAnimalsCount(animals);
//        animalsMap(animals);
        allAnimals(animals);

    }

    //Task 1
    public static void isLionHere(List<Animal> animals) {
        try {
            boolean findLion = animals.stream().anyMatch(animal -> animal.getName().equals("lion"));
            for (Animal animal : animals) {
                if (animal.getName().equals("lion")) {
                    System.out.println("В списке есть лев, его возраст - " + animal.getAge());
                }
            }
        } catch (IllegalArgumentException mistake) {
            System.out.println("Исключение: " + mistake);
        }
    }

    //Task 2
    public static void animalsSort(List<Animal> animals) {
        Map<Integer, String> alimalSorted = animals.stream()
                .sorted(Comparator.comparing(Animal::getAge))
                .collect(Collectors.toMap(Animal::getAge, Animal::getName));
        alimalSorted.forEach((age, name) -> {
            System.out.println("Животное - " + name + ", возраст - " + age);
        });
    }

    //Task 3
    public static void adultAnimalsCount(List<Animal> animals) {
        animals.stream()
                .filter(animal -> animal.getAge() > 4)
                .forEach(animal -> System.out.println(
                        "Животное - " + animal.getName() + ", возраст - " + animal.getAge()));
    }

    //Task 4
    public static void animalsMap(List<Animal> animals) {
        Map<String, Integer> animalsMap = animals.stream()
        .collect(Collectors.toMap(Animal::getName, Animal::getAge));
        animalsMap.forEach((name, age) -> {
            System.out.println("Животное - " + name + ", возраст - " + age);
        });
    }

    //Task 5
    public static void allAnimals(List<Animal> animals) {
        Optional<String> allAnimalsStream = animals.stream()
                .map(Animal::getName)
                .reduce((prev, next) -> prev + ", " + next);
        System.out.println(allAnimalsStream);
    }

}













