/**
 * Класс, описывающий кошку/кота
 */
public class Cat implements Pet {
    /**
     * Кличка животного
     */
    private String name;

    /**
     * Конструктор класса
     * @param name кличка жвотного
     */
    public Cat (final String name) {
        this.name = name;
    }

    @Override
    public void makeSound(){
        System.out.println("Мяу");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(final String name) {
        this.name = name;
    }
}
