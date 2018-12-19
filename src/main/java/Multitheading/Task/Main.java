package Multitheading.Task;

import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(100);
                return 10;
            }
        };
        Task<Integer> task = new Task<>(callable);

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " " + task.get());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }
}

