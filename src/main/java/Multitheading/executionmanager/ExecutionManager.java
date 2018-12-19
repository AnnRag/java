package Multitheading.executionmanager;

import Multitheading.executionmanager.Context;

public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}
