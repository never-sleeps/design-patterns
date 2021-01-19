package facade;

import facade.equipment.Amplifier;
import facade.equipment.DvdPlayer;
import facade.equipment.PopcornMachine;
import facade.equipment.Projector;

public class Main {
    public static void main(String[] args) {
        // Создание экземпляров оборудования
        Amplifier amplifier = new Amplifier();
        DvdPlayer dvdPlayer = new DvdPlayer();
        Projector projector = new Projector();
        PopcornMachine popcornMachine = new PopcornMachine();

        // Создаем фасад со всеми компонентами подсистемы
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(amplifier, dvdPlayer, projector, popcornMachine);
        // Используем упрощённый интерфейс для запуска и для прекращения просмотра:
        homeTheaterFacade.watchMovie("Steve Jobs movie");
        System.out.println();
        homeTheaterFacade.endMovie();
    }
}
