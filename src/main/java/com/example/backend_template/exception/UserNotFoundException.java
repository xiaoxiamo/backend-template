package com.example.backend_template.exception;

/**
 * @ClassName UserNotFoundException
 * @Description
 * @Author L
 * @Date Create by 2020/7/7
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(final String message) {
        super(message);
    }

    public UserNotFoundException(final Throwable cause) {
        super(cause);
    }

    public UserNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
