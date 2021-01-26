Фабрика — это общая концепция проектирования функций, методов и классов, когда какая-то одна часть программы отвечает за создание других частей программы.

Вы можете услышать слово Фабрика от других людей, когда они имеют в виду:
- функцию или метод создающую все объекты программы;
- класс, создающий пользователей системы;
- статический метод, оборачивающий конструктор класса;
- один из классических фабричных паттернов, приведённых ниже.

То, что человек имеет в виду, произнося Фабрика, проще всего понять из контекста,


### Паттерн Простая фабрика
это класс, в котором есть один метод с большим условным оператором, выбирающим создаваемый продукт. Этот метод вызывают с неким параметром, по которому определяется какой из продуктов нужно создать. У простой фабрики, обычно, нет подклассов.

Обычно, простую фабрику путают с общим понятием Фабрики или с любым из фабричных паттернов.

Если объявить класс простой фабрики абстрактным, это не сделает его одним и тем же, что и абстрактная фабрика!
Вот пример простой фабрики:

    class UserFactory {
        public static function create($type) {
            switch ($type) {
                case 'user': return new User();
                case 'customer': return new Customer();
                case 'admin': return new Admin();
                default:
                    throw new Exception('Wrong user type passed.');
            }
        }
    }

### Паттерн Фабричный метод
это устройство классов, при котором подклассы могут переопределять тип создаваемого в суперклассе продукта.

Фабричный метод **основан на наследовании**: создание объектов делегируется субклассам, реализующим фабричный метод для оздания объектов.

**Задача Фабричного метода** - перемещение создания экземпляров в субклассы.

Если вы имеете иерархию продуктов и абстрактный создающий метод, который переопределяется в подклассах, то перед вами паттерн Фабричный метод.

Пример 1:

    abstract class Department {
        public abstract function createEmployee($id);
    
        public function fire($id) {
            $employee = $this->createEmployee($id);
            $employee->paySalary();
            $employee->dismiss();
        }
    }
    
    class ITDepartment extends Department {
        public function createEmployee($id) {
            return new Programmer($id);
        }
    }
    
    class AccountingDepartment extends Department {
        public function createEmployee($id) {
            return new Accountant($id);
        }
    }

Пример 2:

    public class Main {
        public static void main(String[] args) {
            PizzaStore nyPizzaStore = new NYPizzaStore(); // Строим пиццерию в Нью-Йорке
            // пиццерии построены, теперь можно принять заказ:
            // Суперклассу PizzaStore не нужно знать подробности - субкласс NYPizzaStore решает все проблемы, просто создавая правильный экземпляр
            Pizza pizza1 = nyPizzaStore.orderPizza("cheese");
        }
    }
    
    public abstract class PizzaStore {
        /**
         * Субклассы PizzaStore создают экземпляры объектов за нас при вызове orderPizza()
         * @param type наименование пиццы
         * @return приготовленная и порезанная пицца Pizza
         */
        public Pizza orderPizza(String type) {
            Pizza pizza = createPizza(type);
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            return pizza;
        }
    
        /**
         * Вся ответственность за создание экземпляров Pizza перемещена в метод, действующий как фабрика.
         * Фабричный метод объявляется abstract, чтобы субклассы предоставили реализацию создания объектов.
         * Метод изолирует клиента от информации о конкретном тпе создаваемого продукта.
         * @param type тип пиццы
         * @return Pizza
         */
        abstract Pizza createPizza(String type);
    }
    
    public class NYPizzaStore extends PizzaStore {
        @Override
        Pizza createPizza(String type) {
            if (type.equals("cheese")) {
                return new NYStyleCheesePizza();
            } else if (type.equals("pepperoni")) {
                return new NYStylePepperoniPizza();
            } else return null;
        }
    }
    
### Паттерн Абстрактная фабрика
это устройство классов, облегчающее создание семейств продуктов.

Абстрактная фабрика **основана на композиции**: создание объектов реализуется в методе, доступ к которому осуществляется через интерфейс фабрики.

**Задача Абстрактной фабрики** - создание семейств взаимосвязанных объектов без зависимости от их конкретны классов.

Что такое семейство продуктов? Например, классы Транспорт + Двигатель + Управление. Вариациями этого семейства могут стать:
Автомобиль + ДвигательВнутренннегоСгорания + Руль
Самолет + РеактивныйДвигатель + Штурвал
Если у вас нет семейств продуктов, значит не может быть и абстрактной фабрики.

Многие путают паттерн абстрактная фабрика с классом простой фабрики, объявленным как abstract, но это далеко не одно и то же!
    
    public class Main {
        public static void main(String[] args) {
            // Строим пиццерию в Нью-Йорке
            PizzaStore nyPizzaStore = new NYPizzaStore();
            // Заказываем сырную пиццу
            Pizza pizza1 = nyPizzaStore.orderPizza("cheese");
        }
    }
    
    public abstract class PizzaStore {
        public Pizza orderPizza(String type) {
            Pizza pizza = createPizza(type);
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            return pizza;
        }
        abstract Pizza createPizza(String type);
    }
    
    public class NYPizzaStore extends PizzaStore {
        @Override
        Pizza createPizza(String type) {
            // Фабрика производит ингредиенты для всех пицц в Нью-Йоркском стиле
            PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
            Pizza pizza = null;
            if (type.equals("cheese")) {
                pizza = new CheesePizza(ingredientFactory);
            } else if (type.equals("pepperoni")) {
                pizza = new PepperoniPizza(ingredientFactory);
            }
            return pizza;
        }
    }

    public class CheesePizza extends Pizza {
        PizzaIngredientFactory ingredientFactory; // фабрика, поставляющая ингредиенты

        public CheesePizza(PizzaIngredientFactory ingredientFactory) {
            this.ingredientFactory = ingredientFactory;
        }
    
        /**
         * Когда методу prepare требуется какой-либо ингредиент, он запрашивает его у фабрики.
         * При этом может использоваться любая фабрика ингредиентов.
         */
        @Override
        public void prepare() {
            System.out.println("Preparing: " + name);
            dough = ingredientFactory.createDough();
            sauce = ingredientFactory.createSauce();
            cheese = ingredientFactory.createCheese();
        }
    }
    
    /**
     * Интерфейс фабрики, который будет создавать все наши ингредиенты.
     * Для каждого ингредиента в интерфейсе определяется метод create.
     */
    public interface PizzaIngredientFactory {
        public Dough createDough();
        public Sauce createSauce();
        public Cheese createCheese();
        public Veggies[] createVeggies();
        public Pepperoni createPepperoni();
    }
    
    /**
     * Нью-Йоркская фабрика ингредиентов реализует общий интерфейс всех фабрик ингредиентов.
     * Для каждого ингредиента в семействе создается его версия для Нью-Йорка.
     */
    public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
        @Override
        public Dough createDough() { return new ThinCrustDough(); }
    
        @Override
        public Sauce createSauce() { return new MarinaraSauce(); }
    
        @Override
        public Cheese createCheese() { return new ReggianoCheese(); }
    
        @Override
        public Veggies[] createVeggies() { return new Veggies[]{ new Garlic(), new Onion() }; }
    
        @Override
        public Pepperoni createPepperoni() { return new SlicedPepperoni(); }
    }