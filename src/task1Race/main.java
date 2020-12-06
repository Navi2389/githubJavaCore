package task1Race;
/*Урок 1. Класс Object
1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять
соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.

4(*) Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.*/
import java.util.Random;

public class main {
    public static void main(String[] args) {
        Random rand = new Random();

        Actions[] actions = new Actions[3];

        int distance = 11;
        int heigth = 11;
        actions[0] = new Human("Григорий", distance, heigth);

        distance = 12;
        heigth = 12;
        actions[1] = new Robot("Робокоп", distance, heigth);

        distance = 13;
        heigth = 9;
        actions[2] = new Cat("Сэм", distance, heigth);

        Barrier[] barriers = new Barrier[2];

        /*for (int i = 0; i < barriers.length; i++) {
            distance = 10;


            *//*if (distance<100) {
                barriers[i] = new RunTrack("Длина трассы " , distance);
            } else {
                barriers[i] = new Wall("Высота стены " , distance);
            }
        }*/

        boolean isRoad;
        for (int i = 0; i < barriers.length; i++) {
            distance = 10;
            isRoad = rand.nextBoolean();
            if (isRoad) {
                barriers[i] = new RunTrack("Длина трассы ", distance);
            } else {
                barriers[i] = new Wall("Высота стены ", distance);
            }
        }


        for (int i = 0; i < actions.length; i++) {
            boolean result = true;
            for (int j = 0; j < barriers.length; j++) {


                result = barriers[j].moving(actions[i]);

                if (!result) {
                    break;
                }
            }

            if (result) {
                System.out.println("В общем зачете это успех");
                System.out.println();
                System.out.println();
            } else {
                System.out.println("И он выбывает из соревнования");
                System.out.println();
                System.out.println();
            }
        }
    }
}



