public class Lesson_7 {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        checkSumLimits(5, 12);
        positiveOrNegative(1);
        positiveOrNegative1(1);
        stringAndNumber(1);
        leapYear(2021);
        changeArray();
        changeArray1();
        changeArray2();
        squareArray();
        twoArguments(5, 6);
    }

    //Задание 1
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    //Задание 2
    public static void checkSumSign() {
        int a = 5, b = 3;
        int c = a + b;
        if (c >= 0) System.out.println("Сумма положительная");
        else System.out.println("Сумма отрицательная");
    }

    //Задание 3
    public static void printColor() {
        int value = 999;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    //Задание 4
    public static void compareNumbers() {
        int a = 4, b = 4;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    //Задание 5
    public static boolean checkSumLimits(int a, int b) {
        System.out.println("Задание 5");
        int sum = a + b;
        if (sum >= 10 && sum <= 20) return true;
        else return false;
    }

    //Задание 6
    public static void positiveOrNegative(int a) {
        if (a >= 0) System.out.println("Число " + a + " положительное");
        else System.out.println("Число " + a + " отрицательное");
    }

    //Задание 7
    public static boolean positiveOrNegative1(int a) {
        System.out.println("Задание 7");
        if (a < 0) return true;
        return false;
    }

    //Задание 8
    public static void stringAndNumber(int n) {
        String line = "line";
        for (int i = 0; i < n; i++)
            System.out.println(line);
    }


    //Задание 9
    public static boolean leapYear(int year) {
        System.out.println("Задание 9");
        if (!(year % 4 == 0) || ((year % 100 == 0) && !(year % 400 == 0))) return true;
        else return false;
    }

    //Задание 10
    public static void changeArray() {
        int[] arr = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.print("BEFORE: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if (arr[i] == 0) arr[i] = 1;
            else arr[i] = 0;
        }
        System.out.print("\nAFTER:  ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //Задание 11
    public static void changeArray1() {
        int size = 100;
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");
        }
    }

    //Задание 12
    public static void changeArray2() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("\nBEFORE: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.print("\nAFTER:  ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] *= 2;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //Задание 13
    public static void squareArray() {
        int[][] arr = new int[4][4];
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][arr.length - i - 1] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Задание 14
    public static void twoArguments(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
            System.out.print("[" + i + "]" + arr[i] + " ");
        }
    }
}
