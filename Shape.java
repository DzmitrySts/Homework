public interface Shape {
    double getPerimeter();
    double getArea();
    String getFillColor();
    String getBorderColor();

    default String getCharacteristics() {
        return "[" + String.format("%.2f", getPerimeter()) + ", " + String.format("%.2f", getArea()) + ", " + getFillColor() + ", " + getBorderColor() + "]";
    }
}