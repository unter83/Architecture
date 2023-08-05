package chainOfResponsibility;

// Определяет интерфейс для обработки запроса
abstract class Handler {
    protected Handler Successor;
    abstract public void HandleRequest(int condition);
}
// ConcreteHandler1 и ConcreteHandler2: конкретные обработчики, которые реализуют функционал для обработки запроса.
// При невозможности обработки и наличия ссылки на следующий обработчик, передают запрос этому обработчику
class ConcreteHandler1 extends Handler {
    @Override
    public void HandleRequest(int condition) {
        if (condition == 1) {
            System.out.println("Запрос 1 выполнен");
        } else if (Successor != null) {
            Successor.HandleRequest(condition);
        }
    }
}

class ConcreteHandler2 extends Handler {
    @Override
    public void HandleRequest(int condition) {
        if (condition == 2) {
            System.out.println("Запрос 2 выполнен");
        } else if (Successor != null) {
            Successor.HandleRequest(condition);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Handler h1 = new ConcreteHandler1();
        Handler h2 = new ConcreteHandler2();
        h1.Successor = h2;
        h1.HandleRequest(2);
    }


}
