package task1Race;

public class Wall extends Barrier {

    public int heigth;

    public Wall(String name, int heigth) {
        super(name);

        this.heigth = heigth;
    }

    public Wall(int heigth) {
        this();
        this.heigth = heigth;
    }

    public Wall() {
        super();
    }

    public int getHeigth() {
        return heigth;
    }

    @Override
    public boolean moving(Actions actions) {
        System.out.println(super.getName() + this.heigth);

        actions.jump();

        if (getHeigth() <= actions.getJumpHeight()) {
            System.out.println("Перепрыгнул");
            System.out.println();
            return true;
        } else {
            System.out.println("Не запрыгнул, стена оказалась слишком высокой");
            System.out.println();
            return false;
        }
    }
}
