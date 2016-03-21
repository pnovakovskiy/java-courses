package ru.lesson.clinic;

/**
 * Класс, описывающий исключение, выдаваемое пользователю
 */
public class UserException extends Exception {
    public UserException(final String message) {
        super(message);
    }
}
