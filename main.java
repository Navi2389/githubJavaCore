
import java.util.*;
import java.util.stream.Collectors;

public class main {

    public static void main(String[] args) {

        List<Course> listCourses1 = new ArrayList<>();
        listCourses1.add(new Courses("Факультет искусственного интеллекта"));
        listCourses1.add(new Courses("Факультет веб-разработки"));
        listCourses1.add(new Courses("Факультет Python-разработки"));
        listCourses1.add(new Courses("Факультет Frontend-разработки"));
        listCourses1.add(new Courses("Интернет вещей"));
        listCourses1.add(new Courses("Факультет Fullstack JavaScript"));

        List<Course> listCourses2 = new ArrayList<>();
        listCourses2.add(new Courses("Факультет веб-разработки"));
        listCourses2.add(new Courses("Факультет Python-разработки"));
        listCourses2.add(new Courses("Факультет Frontend-разработки"));
        listCourses2.add(new Courses("Интернет вещей"));
        listCourses2.add(new Courses("Факультет Fullstack JavaScript"));

        List<Course> listCourses3 = new ArrayList<>();
        listCourses3.add(new Courses("Факультет Python-разработки"));
        listCourses3.add(new Courses("Факультет Frontend-разработки"));
        listCourses3.add(new Courses("Интернет вещей"));
        listCourses3.add(new Courses("Факультет Fullstack JavaScript"));

        List<Course> listCourses4 = new ArrayList<>();
        listCourses4.add(new Courses("Факультет Frontend-разработки"));
        listCourses4.add(new Courses("Интернет вещей"));
        listCourses4.add(new Courses("Факультет Fullstack JavaScript"));

        List<Course> listCourses5 = new ArrayList<>();
        listCourses5.add(new Courses("Интернет вещей"));
        listCourses5.add(new Courses("Факультет Fullstack JavaScript"));

        List<Course> listCourses6 = new ArrayList<>();
        listCourses6.add(new Courses("Факультет Fullstack JavaScript"));

        List<Student> studentListArray = new ArrayList<>(Arrays.asList(
                new Persons("Мария Скороходова", listCourses1),
                new Persons("Адам Некий", listCourses2),
                new Persons("Рубик-Кубик", listCourses3),
                new Persons("Борис Яковлеквич", listCourses4),
                new Persons("Варя Дариновна", listCourses5),
                new Persons("Арнольд Интернетович", listCourses6)
        ));
        System.out.println("Вывод в консоль всего списка студентв с их курсами:");

        studentListArray.forEach(System.out::println);

        System.out.println("------------------------------ ");
        System.out.println("Вывод в консоль функции, принимающей список Student и возвращающую список уникальных курсов, на которые подписаны студенты:");

        main Functions = new main();
        System.out.println(Functions.uniqueCourses(studentListArray));
        System.out.println("-------------------------------");
        System.out.println("Вывод в консоль функции, принимающую на вход список Student и возвращающую список из трех самых любознательных (любознательность определяется количеством курсов):");

        System.out.println(Functions.theMostActive(studentListArray));
        System.out.println("--------------------------------");
        System.out.println("Вывод в консоль функции, принимающую на вход список Student и экземпляр Course, возвращающую список студентов, которые посещают этот курс:");

        Courses courseFullStack = new Courses("Факультет Fullstack JavaScript");
        System.out.println(Functions.atLeastOne(studentListArray, courseFullStack));
        System.out.println("---------------------------------");

    }

    //Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
    public List<Course> uniqueCourses(List<Student> studentList) {
        return studentList.stream()
                .map(a -> a.getAllCourses())
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }


    //Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных (любознательность определяется количеством курсов).
    public List<Student> theMostActive(List<Student> studentList) {
        return studentList.stream()
                .sorted((b1, b2) -> b2.getAllCourses().size() - b1.getAllCourses().size())
                .limit(3)
                .collect(Collectors.toList());
    }

    //Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов, которые посещают этот курс.
    public List<Student> atLeastOne(List<Student> studentList, Courses courseFullStack) {
        return studentList.stream()
                .filter(c -> c.getAllCourses().contains(courseFullStack))
                .collect(Collectors.toList());
    }
}
//
