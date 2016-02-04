package ru.lesson.clinic;

/**
 * Класс, описывающий исключение, вызываемое при попытке использования "занятого" имени
 */
public class DuplicateNameException extends Exception {
    public DuplicateNameException(final String message) {
        super(message);
    }
}
