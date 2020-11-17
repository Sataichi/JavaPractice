package tasks.task2;

@FunctionalInterface
public interface StringTransformer<T> {

    String transform(T object);

    default boolean isStringEmpty(T object) {
        if (isNull(object)) {
            return true;
        }
        return transform(object).isEmpty();
    }

    default int getStringLength(T object) {
        if (isNull(object)) {
            return 0;
        }
        return transform(object).length();
    }

    static String getSmile() {
        return "༼ つ ◕_◕ ༽つ";
    }

    static boolean isNull(Object object) {
        return object == null;
    }

}
