
public class Courses implements Course {

    String name;

    public Courses(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " ";
    }

    //Для функции, принимающую на вход список Student и экземпляр Course, возвращающую список студентов, которые посещают этот курс.
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Courses other = (Courses) obj;
        if (name != other.getName())
            return false;
        return true;
    }

}






