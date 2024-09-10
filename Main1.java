public class Main1 {

    public static void main(String[] args) {
        // Создание фигур
        Circle circle = new Circle(1, "Красный", "Оранжевый");
        Rectangle rectangle = new Rectangle(2, 3, "Желтый", "зеленый");
        Triangle triangle = new Triangle(4, 5, 6, "Голубой", "Синий");

        // Вывод характеристик
        System.out.println("Характеристики круга: " + circle.getCharacteristics());
        System.out.println("Характеристики прямоугольника: " + rectangle.getCharacteristics());
        System.out.println("Характеристики треугольника: " + triangle.getCharacteristics());
    }
}