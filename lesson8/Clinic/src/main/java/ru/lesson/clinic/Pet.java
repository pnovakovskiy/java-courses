package ru.lesson.clinic;

/**
 * Интерфейс, описывающий домашнее животное
 */
public interface Pet {
    /**
     * Получить имя питомца
     */
    String getName();

    /**
     * Задать имя питомца
     */
    void setName(final String name);
}
