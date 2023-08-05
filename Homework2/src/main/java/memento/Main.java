package memento;

import java.util.Scanner;
import java.util.Stack;

// Класс Memento сохраняет состояние объекта Originator и предоставляет полный доступ только этому объекту Originator
class Memento
{
    public String state;
    public Memento(String state)
    {
        this.state = state;
    }

//    public String getState() {
//        return state;
//    }
//
//    private void setState(String state) {
//        this.state = state;
//    }
}

// Класс Caretaker выполняет только функцию хранения объекта Memento

class Caretaker
{
    public Stack<Memento> history;
    public Caretaker() {
        history = new Stack<Memento>();
    }
}


// Класс Originator создает объект хранителя для сохранения своего состояния
class Originator
{
    private String state;
    public void SetMemento(Memento memento)
    {
        state = memento.state;
    }
    public Memento CreateMemento()
    {
        return new Memento(state);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите  строчку: ");
        String str = sc.nextLine();
        Originator text = new Originator();
        Caretaker moment = new Caretaker();
        text.setState(str);
        moment.history.push(text.CreateMemento());
        System.out.print("Введите ещё одну строчку: ");
        str = sc.nextLine();
        sc.close();
        text.setState(str);
        System.out.println("Восстанавливаем строчку: ");
        text.SetMemento(moment.history.pop());
        System.out.println(text.getState());
//        String text2 = moment.history.pop().state;
//        String text3 = moment.history.pop().state;
//        System.out.println(text2);
//        System.out.println(text3);

    }

}
