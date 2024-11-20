package directory_for_files.Task_02;

class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super("Invalid password");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}