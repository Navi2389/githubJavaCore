package task4Collections;

public class Issue2Main {
    public static void main(String[] args) {
        System.out.println("Создали наш телефонный справочник: ");
        Issue2TelephoneBook telephonebook = new Issue2TelephoneBook();
        System.out.println("☺-☺-☺-☺-☺-☺-☺-☺-☺-☺-☺");
        System.out.println("Заполняем наш телефонный справочник");
        telephonebook.add("Рыбалко", "3-43-65");
        telephonebook.add("Бурков", "3-65-88");
        telephonebook.add("Мельникова", "3-87-66");
        telephonebook.add("Рыбалко", "3-77-77");
        telephonebook.add("Бурков", "3-99-99");
        telephonebook.add("Витязева", "3-09-19");
        telephonebook.add("Метелкин", "3-00-11");
        System.out.println("☺-☺-☺-☺-☺-☺-☺-☺-☺-☺-☺");
        System.out.println("Ищем номер телефона по фамилии: Рыбалко");
        System.out.println(telephonebook.get("Рыбалко"));
        System.out.println("Ищем номер телефона по фамилии: Мельникова");
        System.out.println(telephonebook.get("Мельникова"));
        System.out.println("Если вдруг отсутствует фамилия в телефонном справочнике: Григорьев");
        System.out.println(telephonebook.get("Григорьев"));
        System.out.println("☺-☺-☺-☺-☺-☺-☺-☺-☺-☺-☺");
        System.out.println("Попытка добавить в телефонный справочник уже существующий номер: Метелкин, 3-00-11");
        telephonebook.add("Метелкин", "3-00-11");
    }
}
