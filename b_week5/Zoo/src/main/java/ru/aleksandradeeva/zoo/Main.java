package ru.aleksandradeeva.zoo;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        People people = new People();
        Rhinoceros rhinoceros = new Rhinoceros();
        Monkey monkey = new Monkey();
        Lion lion = new Lion();

        System.out.println("В зоопарк пришли посетители, но все животные ещё спят:");
        people.letsSleep(rhinoceros);
        people.letsSleep(monkey);
        people.letsSleep(lion);

        System.out.println("Наконец животные проснулись, и теперь посетители увидят, как у них проходит завтрак:");
        people.letsEat(rhinoceros);
        people.letsEat(monkey);
        people.letsEat(lion);
    }
}
