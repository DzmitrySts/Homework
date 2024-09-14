public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Степаненко", "+375296911198");
        phoneBook.add("Агапов", "+375291234567");
        phoneBook.add("Логвинов", "+375291112233");
        phoneBook.add("Иванов", "+375299998877");
        phoneBook.add("Агапов", "+375293332211");

        System.out.println("Телефон Степаненко " + phoneBook.get("Степаненко"));
        System.out.println("Телефон Агапова " + phoneBook.get("Агапов"));
        System.out.println("Телефон Логвинова " + phoneBook.get("Логвинов"));
        System.out.println("Телефон Иванова " + phoneBook.get("Иванов"));
    }
}