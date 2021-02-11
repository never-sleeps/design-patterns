package templateMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Coffee extends BeverageWithCaffeine {
    @Override
    void brew() {
        System.out.println("Dripping coffee through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding milk");
    }

    /**
     * Переопределяем метод-перехватчик и задаём нужную функциональность
     * @return нужно ли молоко
     */
    @Override
    boolean customerWantsCondiments() {
        String answer = getUserInput();
        return answer.toLowerCase().equals("yes");
    }

    /**
     * Спрашиваем пользователя, нужно ли добавить в напиток молоко. Входные данный читаются из командной строки.
     * @return ответ пользователя или 'no', если пришло пустое значение.
     */
    private String getUserInput() {
        String answer = null;
        System.out.println("Would you like milk with your coffee (yes/no)?");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("IO error trying to read your answer");
        }
        return (answer == null) ? "no" : answer;
    }

}
