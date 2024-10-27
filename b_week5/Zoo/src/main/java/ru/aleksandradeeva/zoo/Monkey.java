package ru.aleksandradeeva.zoo;

public class Monkey extends AbstractAnimal {
    @Override
    void eat() {
        System.out.println("Я задорная обезьянка, которая любит бананы.");
    }

    @Override
    void sleep() {
        System.out.println("Мы, обезьяны, можем спать как на земле, так и на дереве.");
    }
}
