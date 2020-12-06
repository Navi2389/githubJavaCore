package task2Exception;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
        super("не верный размер массива и поэтому");
    }
}
