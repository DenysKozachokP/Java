package directory_for_files.Task_02;

class WrongLoginException extends Exception {
    public WrongLoginException() {
        super("Invalid login");
    }

    public WrongLoginException(String message) {
        super(message);
    }
}