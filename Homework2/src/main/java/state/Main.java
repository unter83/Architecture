package state;

interface State {
   void Handle(Context context);
}

class StateA implements State {
    public void Handle(Context context) {
        System.out.println("Переход в состояние В");
        context.state = new StateB();
    }
}

class StateB implements State {
    public void Handle(Context context) {
        System.out.println("Переход в состояние А");
        context.state = new StateA();
    }
}

class Context
{
    public State state;
    public Context(State state)   {
        this.state = state;
    }
    public void Request() {
        this.state.Handle(this);
    }
}

public class Main {
    public static void main(String[] args) {
        Context context = new Context(new StateA());
        context.Request(); // Переход в состояние StateB
        context.Request();  // Переход в состояние StateA
    }
}
