package facade;

import facade.equipment.Amplifier;
import facade.equipment.DvdPlayer;
import facade.equipment.PopcornMachine;
import facade.equipment.Projector;

public class HomeTheaterFacade {
    // Композиция: компоненты подсистемы, которые мы собираемся использовать
    private Amplifier amplifier;
    private DvdPlayer dvdPlayer;
    private Projector projector;
    private PopcornMachine popcornMachine;

    // В конструкторе фасада передаются ссылки на все компоненты. Фасад присваивает их соответствующим переменным экземпляра
    public HomeTheaterFacade(Amplifier amplifier, DvdPlayer dvdPlayer, Projector projector, PopcornMachine popcornMachine) {
        this.amplifier = amplifier;
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.popcornMachine = popcornMachine;
    }

    /**
     * Метод просмотра фильма.
     * Выполнение каждой операции делегируется компоненту подсистемы.
     * @param movieName название фильма
     */
    public void watchMovie(String movieName) {
        System.out.println("Get ready to watch a movie: " + movieName + "...");
        popcornMachine.on();    // Включаем машину для попкора
        popcornMachine.pop();   // Включаем приготовление попкорна
        projector.on();         // Включаем проектор
        projector.wideScreenMode(); // Включаем широкоэкранный режим на проекторе
        amplifier.on();         // Включаем усилитель звука
        amplifier.setVolume(5); // Устанавливаем среднюю громкость на усилителе звука
        dvdPlayer.on();         // Включаем dvd-плеер
        dvdPlayer.play(movieName); // Включаем фильм
    }

    /**
     * Метод выключает всю аппаратуру.
     * Каждая операция делегируется соответствующему компоненту подсистемы.
     */
    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        popcornMachine.off();
        projector.off();
        amplifier.off();
        dvdPlayer.off();
    }

}
