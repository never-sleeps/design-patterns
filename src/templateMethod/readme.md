Шаблонный метод — это поведенческий паттерн проектирования, который определяет скелет алгоритма, перекладывая ответственность за некоторые его шаги на подклассы. Паттерн позволяет подклассам переопределять шаги алгоритма, не меняя его общей структуры.

- Паттерн Шаблонный метод предлагает разбить алгоритм на последовательность шагов, описать эти шаги в отдельных методах и вызывать их в одном шаблонном методе друг за другом.
- Это позволит подклассам переопределять некоторые шаги алгоритма, оставляя без изменений его структуру и остальные шаги, которые для этого подкласса не так важны.

Аналогия из жизни:
- Строители используют подход, похожий на шаблонный метод при строительстве типовых домов. У них есть основной архитектурный проект, в котором расписаны шаги строительства: заливка фундамента, постройка стен, перекрытие крыши, установка окон и так далее. Но, несмотря на стандартизацию каждого этапа, строители могут вносить небольшие изменения на любом из этапов, чтобы сделать дом чуточку непохожим на другие.

Структура:
- Абстрактный класс определяет шаги алгоритма и содержит шаблонный метод, состоящий из вызовов этих шагов. Шаги могут быть как абстрактными, так и содержать реализацию по умолчанию.
- Конкретный класс переопределяет некоторые (или все) шаги алгоритма. Конкретные классы не переопределяют сам шаблонный метод.

Применимость:
- Когда подклассы должны расширять базовый алгоритм, не меняя его структуры.
- Когда у вас есть несколько классов, делающих одно и то же с незначительными отличиями. Если вы редактируете один класс, то приходится вносить такие же правки и в остальные классы.

Преимущества:
- Облегчает повторное использование кода.

Недостатки:
- Вы жёстко ограничены скелетом существующего алгоритма.
- Вы можете нарушить принцип подстановки Барбары Лисков, изменяя базовое поведение одного из шагов алгоритма через подкласс.
- С ростом количества шагов шаблонный метод становится слишком сложно поддерживать.


Пример:

    // Абстрактный класс. Он должен субклассироваться классами, предоставляющими реализацию операций
    public abstract class AbstractClass {
        // Шаблонный метод. Объявляется с final, чтобы субклассы не могли изменить последовательность шагов в алгоритме.
        final void templateMethod() {
            primitiveOperation1();
            primitiveOperation1();
            concreteOperation();
            hook();
        }
        
        // Примитив-метод. Должен быть реализован субклассами
        abstract void primitiveOperation1();
        // Примитив-метод. Должен быть реализован субклассами
        abstract void primitiveOperation2();
        
        // Конкретная операция. Объявлена с final, чтобы субклассы не могли её переопределять. 
        // Может использоваться как напрямую шаблонным методом, так и субклассами
        final void concreteOperation() {
            // реализация
        }
        
        // Метод-перехватчик. Субклассы могут переопределять такие методы, но не обязаны.
        void hook(){}
    }
