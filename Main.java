public class Main {

    public static void main(String[] args) {
        String[][] arr = {{"6", "2", "4", "1"}, {"9", "1", "3", "3"}, {"5", "4", "1", "2"}, {"3", "4", "7", "6"}};

        try {
            int sum = array(arr);
            System.out.println("-Сумма элементов массива равна " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("-" + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("-" + e.getMessage());
        }
    }

    public static int array(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4 || arr[0].length != 4) {
            throw new MyArraySizeException("Массив другого размера");
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Лежит символ или текст вместо числа в ячейке [" + i + "][" + j + "]");
                }
            }
        }
        return sum;
    }
}