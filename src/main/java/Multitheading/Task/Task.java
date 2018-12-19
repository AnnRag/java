package Multitheading.Task;

import java.util.concurrent.Callable;

public class Task<T> {

    private final Callable<? extends T> callable;
    private volatile T result = null;
    private volatile MyException exception = null;

    public Task(Callable<? extends T> callable) {
        this.callable = callable;
    }


    public T get() {
        if (result == null) {
            synchronized (this) {
                if (result == null) {
                    try {
                        result = callable.call();
                    } catch (Exception e) {
                        throw new MyException("Exception");
                    }
                }
                return result;
            }
        }
        return result;
    }
}
class MyException extends RuntimeException{
    MyException (String message) {
        super(message);
    }
}
