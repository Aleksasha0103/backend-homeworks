package ru.aleksandradeeva.homework_week11;


public class Task4_Main {
    public static void main(String[] args) throws InterruptedException {
        Thread task4_Car1 = new Thread(new Task4_Car1());
        Thread task4_Car2 = new Thread(new Task4_Car2());

        task4_Car1.start();
        task4_Car2.start();
        task4_Car1.join();
        task4_Car2.join();

        int speed1 = Task4_Car1.getSpeed1();
        int speed2 = Task4_Car2.getSpeed2();
        if (speed1 > speed2) {
            System.out.println("Первым к финишу пришёл автомобиль № 1.");
        } else if (speed1 < speed2) {
            System.out.println("Первым к финишу пришёл автомобиль № 2.");
        } else {
            System.out.println("Автомобили № 1 и № 2 пришли к финишу одновременно.");
        }
    }
}
