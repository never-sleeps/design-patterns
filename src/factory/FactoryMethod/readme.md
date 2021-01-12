Паттерн Фабричный метод определяет интерфейс создания объекта, но позволяет субклассам выбрать класс создаваемого экземпляра. Таким образом, Фабричный метод делегирует операцию создания экземпляра субклассам, то есть он не обладает информацией о фактическом типе создаваемых продуктов.

Если вы имеете иерархию продуктов и абстрактный создающий метод, который переопределяется в подклассах, то перед вами паттерн Фабричный метод.


Пример кода:  

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


