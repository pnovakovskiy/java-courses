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

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String toString() {
        return "Кошка/кот";
    }
}
