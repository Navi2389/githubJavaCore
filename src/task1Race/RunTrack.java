package task1Race;

public class RunTrack extends Barrier {
    private int length;

    public RunTrack(String name, int length) {
        super(name);

        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean moving(Actions actions) {
        System.out.println(super.getName() + this.length);

        actions.run();

        if (getLength() <= actions.getRunDistance()) {
            System.out.println("Пробежал");
            System.out.println();
            return true;
        } else {
            System.out.println("К сожалению, не смог пробежать, наверное, погода помешала");
            System.out.println();
            return false;
        }
    }
}
