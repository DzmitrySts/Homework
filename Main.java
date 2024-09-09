public class Main {
    public static void main(String[] args) {
        Cat catBarsik = new Cat("Барсик");
        Cat catMurzik = new Cat("Мурзик");
        Cat catSnezhok = new Cat("Снежок");
        Dog dogBobik = new Dog("Бобик");

        catBarsik.run(150);
        catMurzik.run(100);
        catSnezhok.run(250);
        dogBobik.run(150);

        catBarsik.swim(10);
        catMurzik.swim(5);
        catSnezhok.swim(1);
        dogBobik.swim(9);

        System.out.println("Создано животных: " + Animal.getAnimalCount());
        System.out.println("Создано собак: " + Dog.getDogCount());
        System.out.println("Создано котов: " + Cat.getCatCount());

        Bowl bowl = new Bowl(10);

        Cat[] cats = {catBarsik, catMurzik, catSnezhok};

        catBarsik.eat(bowl, 3);
        catMurzik.eat(bowl, 7);
        catSnezhok.eat(bowl, 5);

        System.out.println("Барсик сыт: " + catBarsik.isSatiated());
        System.out.println("Мурзик сыт: " + catMurzik.isSatiated());
        System.out.println("Снежок сыт: " + catSnezhok.isSatiated());

        bowl.addFood(15);
        System.out.println("В миске " + bowl.getFoodAmount() + " рыбок");
    }
}