/**
 * Created by Volodymyr Korzhovskyi on 04.01.2017.
 */
//Ответ:
/* Класс Customer создает модель Клиента, в которой определяется его имя
   Поскольку клиенты бывают разные, может случится, что из за какого-то клиента необходимо будет
   изменить метод начисления ренты и тогда придется изменять код класса Customer. Что если изменится
   тип валюты или в стоимость ренты необходимо будет включить дополнительные опции, опять же придется
   изменять класс Customer. Также в таком (последнем виде) легче будет наследоваться от класса, так как
   он имеет больший уровень абстракции. При расширения кода мы сможем уменьшить количество ошибок.
  */

public class Customer {

    private String name;
    // Other fields, constructors, get, set, etc. //
    public Customer(String name) {
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }

// Other methods.

}



