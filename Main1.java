public class Main1 {
    public static void main(String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Person("Sidorov Dmitry ", "Cleaner", "sidmitry@mailbox.com", "892312345", 40000, 33);
        persArray[2] = new Person("Agapov Andrew", "Welder", "agandrew@mailbox.com", "892312346", 50000, 36);
        persArray[3] = new Person("Nivin Anton", "Forester", "nianton@mailbox.com", "892312347", 60000, 39);
        persArray[4] = new Person("Mokshin Kirill", "Pilot", "mokirill@mailbox.com", "892312348", 70000, 42);
        for (Person person : persArray)
            System.out.println(person);
    }
}