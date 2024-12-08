package ru.aleksandradeeva.homeworkweek8;

public class Task5 {
    public static int countOperations(String formula) {
        int count = 0;

        for (int i = 0; i < formula.length(); i++) {
            char ch = formula.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                count++;
            }
        }

        return count;
    }

    public static void selectionSort(String[] formulas) {
        int n = formulas.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (countOperations(formulas[j]) < countOperations(formulas[minIndex])) {
                    minIndex = j;
                }
            }

            String temp = formulas[i];
            formulas[i] = formulas[minIndex];
            formulas[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        String[] formulas = {
                "5+6+32=43",
                "1+1=2",
                "(3+5)*4*21=483",
                "((21-20)*(32-30))/2=1"
        };

        System.out.println("Исходный список формул:");
        for (String formula : formulas) {
            System.out.println(formula);
        }

        selectionSort(formulas);

        System.out.println("\nОтсортированный список формул по сложности:");
        for (String formula : formulas) {
            System.out.println(formula);
        }
    }
}
