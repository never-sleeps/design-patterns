package strategy;

public class Main {
    public static void main(String[] args) {
        Animal fish = new Fish();
        fish.display();
        fish.performMove();

        Animal tiger = new Tiger();
        tiger.display();
        tiger.performMove();
    }
}
