package ru.alexandradeeva.homework_week7;

import java.util.Stack;

public class Task2Brackets {
    public static boolean isTrue(String brackets) {
        Stack<String> bracketsStack = new Stack<>();
        for (String i : brackets.split("")) {
            if (i.equals("(") || i.equals("[") || i.equals("{")) {
                bracketsStack.push(i);
            } else if (i.equals(")") || i.equals("]") || i.equals("}")) {
                if (bracketsStack.isEmpty()) {
                    return false;
                }
                String last = bracketsStack.pop();
                if (i.equals(")") && !last.equals("(")) {
                    return false;
                } else if (i.equals("]") && !last.equals("[")) {
                    return false;
                } else if (i.equals("}") && !last.equals("{")) {
                    return false;
                }
            }
        }

        return bracketsStack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isTrue("([)]")); // false
        System.out.println(isTrue("(]")); // false
        System.out.println(isTrue("()[]{}")); // true
        System.out.println(isTrue("()")); // true
    }
}
