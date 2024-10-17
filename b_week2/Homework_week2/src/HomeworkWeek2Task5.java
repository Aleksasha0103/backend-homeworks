
public class HomeworkWeek2Task5 {
    public static void main (String[] args) {
        //Упаковка
        byte a = 13;
        Byte boxed1;
        boxed1 = new Byte(a);                       //через конструктор
        boxed1 = Byte.valueOf(a);                  //через метод .valueOf(a)
        boxed1 = a;                               //автоматическая

        short b = 555;
        Short boxed2;
        boxed2 = new Short(b);                      //через конструктор
        boxed2 = Short.valueOf(b);                 //через метод .valueOf(a)
        boxed2 = b;                               //автоматическая

        int c = 777;
        Integer boxed3;
        boxed3 = new Integer(c);                    //через конструктор
        boxed3 = Integer.valueOf(c);               //через метод .valueOf(a)
        boxed3 = c;                               //автоматическая

        long d = 1234567890L;
        Long boxed4;
        boxed4 = new Long(d);                       //через конструктор
        boxed4 = Long.valueOf(d);                  //через метод .valueOf(a)
        boxed4 = d;                               //автоматическая

        double e = 1.2572468;
        Double boxed5;
        boxed5 = new Double(e);                     //через конструктор
        boxed5 = Double.valueOf(e);                //через метод .valueOf(a)
        boxed5 = e;                               //автоматическая

        float f = 1.25F;
        Float boxed6;
        boxed6 = new Float(f);                      //через конструктор
        boxed6 = Float.valueOf(f);                 //через метод .valueOf(a)
        boxed6 = f;                               //автоматическая

        char g = '\u044B';
        Character boxed7;
        boxed7 = Character(g);                      //через конструктор
        boxed7 = Character.valueOf(g);             //через метод .valueOf(a)
        boxed7 = g;                               //автоматическая

        boolean h = true;
        Boolean boxed8;
        boxed8 = new Boolean(h);                    //через конструктор
        boxed8 = Boolean.valueOf(h);               //через метод .valueOf(a)
        boxed8 = h;                               //автоматическая


        //Распаковка
        Byte boxed9 = 13;
        byte i;
        i = boxed9.byteValue();                   //через методы
        i = boxed9;                               //автоматическая

        Short boxed10 = 555;
        short j;
        j = boxed10.shortValue();                   //через методы
        j = boxed10;                               //автоматическая

        Integer boxed11 = 777;
        int k;
        k = boxed11.intValue();                     //через методы
        k = boxed11;                               //автоматическая

        Long boxed12 = 1234567890L;
        long l;
        l = boxed12.longValue();                    //через методы
        l = boxed12;                               //автоматическая

        Double boxed13 = 1.2572468;
        double m;
        m = boxed13.doubleValue();                  //через методы
        m = boxed13;                               //автоматическая

        Float boxed14 = 1.25F;
        float n;
        n = boxed14.floatValue();                   //через методы
        n = boxed14;                               //автоматическая

        Character boxed15 = '\u044B';
        char o;
        o = boxed15.charValue();                    //через методы
        o = boxed15;                               //автоматическая

        Boolean boxed16 = true;
        boolean p;
        p = boxed16.booleanValue();                 //через методы
        p = boxed16;                               //автоматическая
    }
}
