package tasks.task3;

public class Handler {

    private Handler nextHandler;

    private String name;

    private ThreeFunction<HandleObject, Double, Double, Color> handleFunction;

    public Handler(String name, ThreeFunction<HandleObject, Double, Double, Color> handleFunction) {
        this.name = name;
        this.handleFunction = handleFunction;
    }

    public HandleObject handle(HandleObject handleObject) {
        System.out.println("Got object : "+ handleObject.toString());
        HandleObject newObj =
            handleFunction.execute(handleObject.getDistance(), handleObject.getSize(), handleObject.getColor());
        System.out.println("Handler " + name + " function executed");
        if (nextHandler != null) {
            System.out.println("Passing to handler " + nextHandler.getName());
            return nextHandler.handle(newObj);
        } else {
            System.out.println(
                "Chain processing completed. Last handler " + name + ". Processed object: " + newObj.toString());
            return newObj;
        }
    }

    ;

    public void setNextHandler(Handler handler) {
        nextHandler = handler;
    }

    public String getName() {
        return name;
    }
}
