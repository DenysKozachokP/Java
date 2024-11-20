package directory_for_files.Task_02;

import directory_for_files.Task_02.WrongLoginException;
import directory_for_files.Task_02.WrongPasswordException;

public class CredentialsChecker {
    public static boolean checkCredentials(String login, String password, String confirmPassword) {
        try {
            if (login == null || !login.matches("[a-zA-Z0-9_]+") || login.length() >= 20) {
                throw new WrongLoginException("Login must contain only letters, digits, or underscores and be less than 20 characters.");
            }
            if (password == null || !password.matches("[a-zA-Z0-9_]+") || password.length() >= 20) {
                throw new WrongPasswordException("Password must contain only letters, digits, or underscores and be less than 20 characters.");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Password and confirm password do not match.");
            }

            return true;

        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(checkCredentials("valid_login", "securePassword1", "securePassword1"));
        System.out.println(checkCredentials("invalid login!", "securePassword1", "securePassword1"));
        System.out.println(checkCredentials("valid_login", "short", "not_matching"));
        System.out.println(checkCredentials("very_long_login_that_exceeds_limit", "securePassword1", "securePassword1"));
    }
}