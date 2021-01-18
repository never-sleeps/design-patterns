package adapter.objectAdapter;

/**
 * Вид индюшки: Дикая индюшка
 */
public class WildTurkey implements Turkey{
    @Override
    public void qobble() {
        System.out.println("Gobble");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}
