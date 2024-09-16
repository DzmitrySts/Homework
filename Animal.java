public abstract class Animal {
    private String name;
    private static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public String getName() {
        return name;
    }

    public void run(int distance) {
        if (distance > getRunLimit()) {
            System.out.println(name + " не может пробежать " + distance + " м");
        } else {
            System.out.println(name + " пробежал " + distance + " м");
        }
    }

    public void swim(int distance) {
        if (distance > getSwimLimit()) {
            System.out.println(name + " не может проплыть " + distance + " м");
        } else {
            System.out.println(name + " проплыл " + distance + " м");
        }
    }

    protected abstract int getRunLimit();

    protected abstract int getSwimLimit();
}

class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    protected int getRunLimit() {
        return 500;
    }

    @Override
    protected int getSwimLimit() {
        return 10;
    }
}

class Cat extends Animal {
    private static int catCount = 0;
    private boolean satiated = false;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    protected int getRunLimit() {
        return 200;
    }

    @Override
    protected int getSwimLimit() {
        return 0;
    }

    public void eat(Bowl bowl, int foodAmount) {
        if (bowl.getFoodAmount() >= foodAmount) {
            bowl.takeFood(foodAmount);
            satiated = true;
            System.out.println(getName() + " съел " + foodAmount + " рыбки из миски");
        } else {
            System.out.println(getName() + " не смог съесть " + foodAmount + " рыбок");
        }
    }

    public boolean isSatiated() {
        return satiated;
    }
}

class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void takeFood(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
        } else {
            System.out.println("В миске недостаточно еды");
        }
    }

    public void addFood(int amount) {
        foodAmount += amount;
    }
}