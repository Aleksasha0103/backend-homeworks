package ru.aleksandradeeva.zoo;

public class People {
    void letsEat(AbstractAnimal abstractAnimal) {
        System.out.println("Мы посетители зоопарка и хотим посмотреть, что едят разные животные.");
        abstractAnimal.eat();
    }

    void letsSleep (AbstractAnimal abstractAnimal) {
        System.out.println("Мы посетители зоопарка, и нам интересно, как спят зверухи.");
        abstractAnimal.sleep();
    }
}
