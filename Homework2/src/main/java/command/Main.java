package command;

// интерфейс, представляющий команду
interface Command {
    void Execute();
    void Undo();

}
// конкретная реализация команды, реализует метод Execute(),
// в котором вызывается определенный метод, определенный в классе Receiver
class ConcrateCommand implements Command {
    Receiver receiver;

    public ConcrateCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void Execute() {
        receiver.Operation();
    }

    @Override
    public void Undo() {
        System.out.println("Отмена");
    }
}

//Получатель команды. Определяет действия, которые должны выполняться в результате запроса.
class Receiver {
    public void Operation() {
        System.out.println("Выполнение операции");
    }
}

// Инициатор команды - вызывает команду для выполнения определенного запроса
class Invoker {
    Command command;
    public void setCommand(Command c) {
        command = c;
    }

    public void Run(){
        command.Execute();

    }

    public void Cancel(){
        command.Undo();
    }
}

public class Main {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Receiver receiver = new Receiver();
        ConcrateCommand command = new ConcrateCommand(receiver);
        invoker.setCommand(command);
        invoker.Run();
        invoker.Cancel();
    }
}
