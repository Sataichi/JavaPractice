package tasks.task3;

@FunctionalInterface
public interface ThreeFunction<T,ARG1,ARG2,ARG3> {
    T execute(ARG1 arg1, ARG2 arg2, ARG3 arg3);
}
