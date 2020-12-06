package task2Exception;

public class main {
    /*Урок 2. Исключения
1. Написать метод, на вход которому подается двумерный строковый массив размером 4х4.
При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
Если в каком-то элементе преобразование не удалось (например, если в ячейке лежит символ или текст вместо числа),
надо бросить исключение MyArrayDataException с детализацией, в какой ячейке неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException и вывести результат расчета.*/


    public static void main(String[] args) {

        int result = 0;

        String[][] array = {{"2", "2", "2", "2"}, {"2", "2", "2", "2"}};
        String[][] error_array = {{"2", "3", "4", "5", "2"}, {"2", "3", "4", "5"}};
        String[][] error_data = {{"2", "2", "4", "5",}, {"2", "3", "4", "ФF@5"}};

        System.out.println("Программа приступила к работе");
        System.out.println("☺-☺-☺-☺-☺-☺-☺-☺-☺-☺-☺");
        System.out.println();

        System.out.println("Вывод результата расчета корректного массива: ");
        try {
            result = 0;
            result = analyze(array);
        } catch (MyArraySizeException myarraysizeexception) {
            System.out.println(myarraysizeexception.getMessage());
        } catch (MyArrayDataException myarraydataexception) {
            System.out.println(myarraydataexception.getMessage());
        } finally {
            System.out.println("сумма элементов массива равна " + String.valueOf(result));
            System.out.println("☻-☻-☻-☻-☻-☻-☻-☻-☻-☻-☻-☻");
            System.out.println();
        }

        System.out.println("Вывод результата расчета, если массив некорректен:");
        try {
            result = 0;
            result = analyze(error_array);
        } catch (MyArraySizeException myarraysizeexception) {
            System.out.println(myarraysizeexception.getMessage());
        } catch (MyArrayDataException myarraydataexception) {
            System.out.println(myarraydataexception.getMessage());
        } finally {
            System.out.println("сумма элементов массива равна " + String.valueOf(result));
            System.out.println("¯\\_(ツ)_/¯=¯\\_(ツ)_/¯=¯\\_(ツ)_/¯=¯\\_(ツ)_/¯=¯\\_(ツ)_/¯");
            System.out.println();
        }

        System.out.println("Определение положения ошибочных данных в массиве: ");
        try {
            result = 0;
            result = analyze(error_data);
        } catch (MyArraySizeException myarraysizeexception) {
            System.out.println(myarraysizeexception.getMessage());
        } catch (MyArrayDataException myarraydataexception) {
            System.out.println(myarraydataexception.getMessage());
        } finally {
            System.out.println(" и поэтому сумма элементов массива равна " + String.valueOf(result));
            System.out.println("(ಥ_ಥ)   (ಥ_ಥ)     (ಥ_ಥ)   (ಥ_ಥ)     (ಥ_ಥ)   (ಥ_ಥ)");
            System.out.println();
        }

        System.out.println("Программа завершила работу, компьютеру требуется перерыв. Сходите попейте чаю. Приятного чаепития!");
    }

    public static int analyze(String[][] array) throws MyArraySizeException, MyArrayDataException {

        int summ = 0;
        int value = 0;
        int row = 0;
        int cell = 0;

        if (array.length != 2 || array[0].length != 4 || array[1].length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 1; i < 3; i++) {
            row = i;
            for (int c = 1; c < 5; c++) {
                cell = c;
                try {
                    value = Integer.parseInt(array[i - 1][c - 1]);
                    summ += value;
                } catch (IllegalArgumentException e) {
                    String message = "в " + String.valueOf(row) + " ряду, " + String.valueOf(cell) + " ячейке";
                    throw new MyArrayDataException(message);
                }
            }
        }

        return summ;
    }
}

