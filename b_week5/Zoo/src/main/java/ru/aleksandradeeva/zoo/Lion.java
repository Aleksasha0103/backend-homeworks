package ru.aleksandradeeva.zoo;

public class Lion extends AbstractAnimal {
    @Override
    void eat() {
        System.out.println("Я лев, люблю трапезничать мясом.");
    }

    @Override
    void sleep() {
        super.sleep();
        System.out.println("Любой уважающий себя лев может спать как на земле, так и на дереве. К тому же, предпочитаю это делать днём.");
   }
}
