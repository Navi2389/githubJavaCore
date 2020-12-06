package task1Race;

public class Cat implements Actions {
    public String name;
    public int runDistance;
    public int jumpHeight;

    public Cat(String name, int distance, int jumpHeight) {
        this.name = name;
        this.runDistance = distance;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public void run() {
        System.out.println("Кот " + this.name + " пробежал " + this.getRunDistance());
    }

    @Override
    public void jump() {
        System.out.println("Кот " + this.name + " прыгнул " + this.getJumpHeight());
    }

    @Override
    public int getRunDistance() {
        return this.runDistance;
    }

    @Override
    public int getJumpHeight() {
        return this.jumpHeight;
    }
}
