package Task1;
interface Eatable {

    void eat();
}

interface Workable {

    void work();
}


class HumanWorker implements Workable, Eatable {
    public void work() {
        System.out.println("Человек работает");
    }

    public void eat() {
        System.out.println("Человек ест");
    }
}

class RobotWorker implements Workable {
    public void work() {
        System.out.println("Робот работает");
    }
}


public class Main {
    public static void main(String[] args) {
        RobotWorker worker1 = new RobotWorker();
        worker1.work();
        HumanWorker worker2 = new HumanWorker();
        worker2.work();
        worker2.eat();
    }
}
