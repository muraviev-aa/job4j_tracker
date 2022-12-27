package ru.job4j.early;

public class PasswordValidator {
    private static final String[] INCORRECT_VALUE = {"qwerty", "12345", "password", "admin", "user"};

    public static String validate(String password) {

        boolean up = false;
        boolean low = false;
        boolean dig = false;
        boolean simb = false;

        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                up = true;
            }
            if (Character.isLowerCase(ch)) {
                low = true;
            }
            if (Character.isDigit(ch)) {
                dig = true;
            }
            if (!Character.isLetter(ch) && !Character.isDigit(ch)) {
                simb = true;
            }
            if (up && low && dig && simb) {
                break;
            }
        }
        if (!up) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!low) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!dig) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!simb) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        for (String string : INCORRECT_VALUE) {
            if (password.toLowerCase().contains(string)) {
                throw new IllegalArgumentException(
                        "Password shouldn't contain substrings: qwerty, 12345, password, admin, user"
                );
            }
        }
        return password;
    }
}
