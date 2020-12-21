package task5CSVInputStreamOutputStream2;

/*
Реализовать сохранение данных в csv файл;
Реализовать загрузку данных из csv файла. Файл читается целиком.
Структура csv файла:
Строка заголовок с набором столбцов
Набор строк с целочисленными значениями
Разделитель между столбцами - символ точка с запятой (;)
Пример:
Value 1;Value 2;Value 3
100;200;123
300,400,500
Для хранения данных использовать класс вида:
public class AppData {
private String[] header;
private int[][] data;
}
Если выполняется save(AppData data), то старые данные в файле полностью перезаписываются.
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //делаем заголовок Value
        int from = 3;
        int until = 4;
        String[] headMassive = new String[until];
        for (int i = 0; i < headMassive.length; i++) {
            headMassive[i] = "Value " + i;
        }
//делаем содержимое (данные) data
        int[][] dataMassive = new int[from][until];
        for (int i = 0; i < dataMassive.length; i++) {
            for (int j = 0; j < dataMassive[i].length; j++) {
                dataMassive[i][j] = (int) (Math.random() * 100);
            }
        }

        AppData value = new AppData(headMassive, dataMassive);
        value.getHeader();
//записываем информацию в файл CSV "RecordCsv"
        try (PrintWriter DataValue = new PrintWriter("RecordCsv.csv")) {
            for (int i = 0; i < value.getHeader().length - 1; i++) {
                DataValue.print(value.getHeader()[i] + "; ");
            }
            DataValue.println(value.getHeader()[value.getHeader().length - 1]);

            for (int i = 0; i < value.getData().length - 1; i++) {
                for (int j = 0; j < value.getData()[i].length - 1; j++) {
                    DataValue.print(value.getData()[i][j] + "; ");
                }
                DataValue.println(value.getData()[i][value.getData()[i].length - 1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//считываем информацию из файла CSV "RecordCsv"
        try (BufferedReader ValueData = new BufferedReader(new FileReader("RecordCsv.csv"))) {
            String str = null;
            while ((str = ValueData.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

