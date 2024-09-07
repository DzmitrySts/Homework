public class Main2 {
    public static void main(String[] args) {
        Park park = new Park();
        Park.Attraction super8 = park.new Attraction("Супер восемь", "09:00", "21:00", 5);

        System.out.println(super8);
    }
}