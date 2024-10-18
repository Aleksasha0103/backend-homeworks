package ru.alexandradeeva.shipandfish;

public class Main {
    public static void main(String[] args) {
        Fish fish = new Fish();
        Ship ship = new Ship();

        MakeSwim makeSwim = new MakeSwim();

        makeSwim.letsSwim(fish);
        makeSwim.letsSwim(ship);

    }
}
