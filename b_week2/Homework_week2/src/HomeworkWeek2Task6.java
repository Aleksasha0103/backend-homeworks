public class HomeworkWeek2Task6 {
    public static void main(String[] args) {
            int a = 5;
            int b = 8;
            double squareC = a * a + b * b;
            double c = Math.sqrt(squareC);
            double p = a + b + c;
            int s = (a * b) / 2;

            System.out.println("Катет a = " + a + " см");
            System.out.println("Катет b = " + b + " см");
            System.out.println("Найти площадь и периметр. Решение:");
            System.out.println("Гипотенуза c = " + c + " см");
            System.out.println("Периметр P = " + p + " см");
            System.out.println("Площадь S = " + s + " см");
            System.out.println("Выяснить: больше ли периметр 15 и меньше ли площадь 30? Сравнение:");
            System.out.println("Периметр P больше 15 см: " + (p > 15));
            System.out.println("Площадь S меньше 30 см: " + (s < 30));
    }
}