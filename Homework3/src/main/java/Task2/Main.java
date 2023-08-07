package Task2;

class Text  {
    private String text;

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

class PrintableText extends Text {
    private Printable printer;

    public PrintableText(String text, Printable printer) {
        super(text);
        this.printer = printer;
    }

    public void Print() {
        printer.print(super.getText());
    }
}

interface Printable {
    public void print(String msg);
}

class Printer implements Printable {
    public void print(String msg) {
        System.out.println("Печать текста: " + msg);
    }
}

public class Main {
    public static void main(String[] args) {
        PrintableText myText = new PrintableText("Hello, world!", new Printer());
        myText.Print();


    }
}