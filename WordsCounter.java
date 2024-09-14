import java.util.*;

public class WordsCounter {
    public static void main(String[] args) {
        String[] arr = {"Автомобиль", "Насос", "Лестница", "Кочерга", "Кровать", "Кочерга", "Окно", "Автомобиль", "Кровать", "Культиватор", "Кровать", "Кочерга", "Окно", "Жалюзи", "Насос", "Компьютер", "Жалюзи", "Расческа", "Картина", "Картина", "Картина", "Картина", "Картина"};

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : arr) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Cлова и их количество");
        for (Map.Entry<String, Integer> e : wordCount.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}