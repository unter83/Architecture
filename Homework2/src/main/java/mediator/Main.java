package mediator;

//  интерфейс для взаимодействия с объектами Colleague
interface Mediator {
    void Send(String msg, Colleague colleague);
}

// представляет абстрактный класс для взаимодействия с объектом Mediator
abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

}

//   ConcreteColleague1 и ConcreteColleague2 классы коллег, которые обмениваются друг с другом через объект Mediator

class ConcreteColleague1 extends Colleague {

    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    public void Sent(String msg) {
        mediator.Send(msg, this);
    }

    public void Notify(String msg) {
        System.out.println("Уведомление1: " + msg);
    }
}

class ConcreteColleague2 extends Colleague {

    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    public void Sent(String msg) {
        mediator.Send(msg, this);
    }

    public void Notify(String msg) {
        System.out.println("Уведомление2: " + msg);
    }
}

//  посредник, реализующий интерфейс типа Mediator
class ManagerMediator implements Mediator {
    public ConcreteColleague1 colleague1;
    public ConcreteColleague2 colleague2;


    @Override
    public void Send(String msg, Colleague colleague) {
        // если отправитель - коллега 1, уведомить коллегу 2
        if (colleague1 == colleague)
            colleague2.Notify(msg);
        // иначе отправитель - коллега 2, уведомить коллегу 1
        else
            colleague1.Notify(msg);
    }
}

public class Main {

    public static void main(String[] args) {
        ManagerMediator mediator = new ManagerMediator();
        Colleague colleague1 = new ConcreteColleague1(mediator);
        Colleague colleague2 = new ConcreteColleague2(mediator);
        mediator.colleague1 = (ConcreteColleague1) colleague1;
        mediator.colleague2 = (ConcreteColleague2) colleague2;
        ((ConcreteColleague1) colleague1).Sent("Уведомление коллеги 2");
        ((ConcreteColleague2) colleague2).Sent("Уведомление коллеги 1");
    }

}
