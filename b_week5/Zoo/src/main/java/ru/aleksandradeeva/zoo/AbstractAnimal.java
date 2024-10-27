package ru.aleksandradeeva.zoo;

public abstract class AbstractAnimal {
    abstract void eat();

    void sleep() {
        System.out.println("Я сплю как большинство животных, ничего особенного.");
    }
}
