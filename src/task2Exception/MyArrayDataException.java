package task2Exception;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String message) {
        super("ошибочные данные располагаются " + message);
    }
}
