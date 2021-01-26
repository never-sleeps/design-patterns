package strategy;

import strategy.animal.Animal;
import strategy.animal.Fish;
import strategy.animal.Tiger;

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
