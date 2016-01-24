/**
 * Интерфейс, описывающий домашнее животное
 */
public interface Pet {
    /**
     * Издать звук
     */
    //void makeSound();

    /**
     * Получить имя питомца
     */
    String getName();

    /**
     * Задать имя питомца
     */
    void setName(final String name);
}
