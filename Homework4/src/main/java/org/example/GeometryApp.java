package org.example;
abstract class Shape  {

}

interface ShapeCalculation {

    /**
     * Вычисляет площадь фигуры
     * @param shape фигура типа Circle, Rectangle или Triangle
     * @return  площадь в формате double
     */
    double getArea(Shape shape);

    /**
     * Вычисляет периметр фигуры
     * @param shape фигура типа Circle, Rectangle или Triangle
     * @return  площадь в формате double
     */
    double getPerimeter(Shape shape);
}

/**
 *  Класс для вычисления площади круга
 */

class CalculateCircle implements ShapeCalculation {
    @Override
    public double getArea(Shape shape) {
        Circle circle = (Circle) shape;
        return Math.PI * circle.getRadius() * circle.getRadius();
    }

    @Override
    public double getPerimeter(Shape shape) {
        Circle circle = (Circle) shape;
        return 2 * Math.PI * circle.getRadius();
    }
}

// Класс для круга
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

/**
 *  Класс для вычисления площади прямоугольника
 */
class CalculateRectangle implements ShapeCalculation {

    @Override
    public double getArea(Shape shape) {
        Rectangle rectangle = (Rectangle) shape;
        return rectangle.getLength() * rectangle.getWidth();
    }

    @Override
    public double getPerimeter(Shape shape) {
        Rectangle rectangle = (Rectangle) shape;
        return 2 * rectangle.getLength() + 2 * rectangle.getWidth();
    }
}

// Класс для прямоугольника
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
}

/**
 *  Класс для вычисления площади треугольника
 */
class CalculateTriangle implements ShapeCalculation {

    @Override
    public double getArea(Shape shape) {
        Triangle triangle = (Triangle) shape;
        double s = (triangle.getSide1() + triangle.getSide2() + triangle.getSide3()) / 2;
        return Math.sqrt(s * (s - triangle.getSide1()) * (s - triangle.getSide2()) * (s - triangle.getSide3()));
    }

    @Override
    public double getPerimeter(Shape shape) {
        Triangle triangle = (Triangle) shape;
        return triangle.getSide1() + triangle.getSide2() + triangle.getSide3();
    }
}

// Класс для треугольника

class Triangle  extends  Shape{
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }


}

// Главный класс приложения
public class GeometryApp {
    public static void main(String[] args) {
        // Пример использования конкретных классов геометрических фигур
        ShapeCalculation circleArea = new CalculateCircle();
        ShapeCalculation rectangleArea = new CalculateRectangle();
        ShapeCalculation triangleArea = new CalculateTriangle();

        Shape circle = new Circle(5.0);

        System.out.println("Площадь круга: " + circleArea.getArea(circle));
        System.out.println("Периметр круга: " + circleArea.getPerimeter(circle));

        Shape rectangle = new Rectangle(4.0, 6.0);
        System.out.println("Площадь прямоугольника: " + rectangleArea.getArea(rectangle));
        System.out.println("Периметр прямоугольника: " + rectangleArea.getPerimeter(rectangle));

        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        System.out.println("Площадь треугольника: " + triangleArea.getArea(triangle));
        System.out.println("Периметр треугольника: " + triangleArea.getPerimeter(triangle));

    }
}