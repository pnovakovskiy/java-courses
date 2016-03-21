package ru.lesson.calculator;

/**
 * Класс, описывающий исключение, выдаваемое пользователю
 */
public class UserException extends Exception {
    public UserException(final String message) {
        super(message);
    }
}
