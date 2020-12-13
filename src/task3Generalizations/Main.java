package task3Generalizations;

/*
Урок 3. Обобщения
1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
2. Задача:
-Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
-Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну
коробку нельзя сложить и яблоки, и апельсины;
- Для хранения фруктов внутри коробки можно использовать ArrayList;
- Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
-Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
Можно сравнивать коробки с яблоками и апельсинами;
-Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку
фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов
не остается, а в другую перекидываются объекты, которые были в первой;
-Не забываем про метод добавления фрукта в коробку.
 */

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //1. Написали метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
        Integer arr1[] = {1, 2, 3, 4, 5, 6, 7};
        String arr2[] = {"O", "P", "Q"};
        change(arr1, 1, 4);
        change(arr2, 0, 2);

        //Задача 2

        Box<Orange> orange = new Box<>();
        Box<Orange> orange1 = new Box<>();
        Box<Apple> apple = new Box<>();
        Box<Apple> apple1 = new Box<>();
        System.out.println("Задание 2");
        System.out.println("Добавили фрукты: ");
        orange.addFruit(new Orange(), 4);
        orange1.addFruit(new Orange(), 2);
        apple.addFruit(new Apple(), 3);
        apple1.addFruit(new Apple(), 1);
        System.out.println("Коробка 1 с апельсинами 1 сорта: " + orange.getWeight() + " кг");
        System.out.println("Коробка 2 с апельсинами другого сорта: " + orange1.getWeight() + " кг");
        System.out.println("Коробка 3 с яблоками 1 сорта: " + apple.getWeight() + " кг");
        System.out.println("Коробка 4 с яблоками другого сорта: " + apple1.getWeight() + " кг");
        System.out.println("Сравниваем одну коробку с другой: ");
        System.out.println("Коробка 1 равна коробке 3: " + orange.compare(apple));
        System.out.println("Коробка 2 равна коробке 4: " + orange1.compare(apple1));
        System.out.println("Пересыпаем фрукты из одной коробки в другую (яблоки к яблокам, апельсины к апельсинам) ");
        orange.transfer(orange1);
        apple.transfer(apple1);
        System.out.println("и получаем вес каждой коробки: ");
        System.out.println("Коробка 1: " + orange.getWeight() + " кг");
        System.out.println("Коробка 2: " + orange1.getWeight() + " кг");
        System.out.println("Коробка 3: " + apple.getWeight() + " кг");
        System.out.println("Коробка 4: " + apple1.getWeight() + " кг");


    }

    public static void change(Object[] arr, int e1, int e2) {
        System.out.println("Задание 1 - массив до смены местами элекментов: " + Arrays.toString(arr));
        Object ch = arr[e1];
        arr[e1] = arr[e2];
        arr[e2] = ch;
        System.out.println("массив после смены местами элементов: " + Arrays.toString(arr) + "\n☺-☺-☺-☺-☺-☺-☺-☺-☺-☺-☺");
    }

}
