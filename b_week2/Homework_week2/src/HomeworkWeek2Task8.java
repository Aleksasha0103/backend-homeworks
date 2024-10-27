import java.time.LocalDate;

public class HomeworkWeek2Task8 {
    public static void main(String[] args) {
        String text = "Training Java";
        LocalDate currentDate = LocalDate.now();

        System.out.println("Исходная фраза: ");
        System.out.println("Training Java");
        System.out.println("Длина фразы: " + text.length());
        System.out.println("Символ на 5-й позиции (отсчёт с нуля): " + text.charAt(5));
        System.out.println("Фраза и текущая дата: " + text + " " + currentDate);
    }
}
