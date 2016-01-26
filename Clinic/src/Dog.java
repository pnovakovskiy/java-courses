/**
 * Класс, описывающий кошку/кота
 */
public class Dog implements Pet {
    /**
     * Кличка животного
     */
    private String name;

    /**
     * Конструктор класса
     * @param name кличка жвотного
     */
    public Dog (final String name) {
        this.name = name;
    }

    //@Override
    //public void makeSound(){
    //    System.out.println("Гав");
    //}

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String toString() {
        return "Собака";
    }
}
