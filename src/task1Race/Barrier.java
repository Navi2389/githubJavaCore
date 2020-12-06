package task1Race;

public abstract class Barrier {
    public String name;

    public Barrier(String name) {
        this.name = name;
    }

    public Barrier() {

    }

    abstract boolean moving(Actions actions);

    public String getName() {
        return name;
    }
}


