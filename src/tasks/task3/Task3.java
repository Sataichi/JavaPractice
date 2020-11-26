package tasks.task3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task3 {

    //Word of mouth
    public static void main(String[] args) {

        ThreeFunction<HandleObject, Double, Double, Color> colorBlindHandlerFunction = (d, s, c) -> {
            Color color;
            switch (c) {
                case Red:
                    color = Color.Orange;
                    break;
                case Green:
                    color = Color.Yellow;
                    break;
                case Pink:
                    color = Color.Purple;
                    break;
                case Purple:
                    color = Color.Blue;
                    break;
                default:
                    color = c;
            }
            return new HandleObject(d, s, color);
        };

        ThreeFunction<HandleObject, Double, Double, Color> astigmatismHandlerFunction =
                (d, s, c) -> new HandleObject(d * 0.8, s * 1.2, c);

        List<Handler> handlerList = Stream.of(new Handler("ColorBlindHandlerWithDeuteranomaly", colorBlindHandlerFunction),
                new Handler("HandlerWithAstigmatism", astigmatismHandlerFunction))
                .collect(Collectors.toList());

        for (int i = 0; i < handlerList.size() - 1; i++) {
            handlerList.get(i).setNextHandler(handlerList.get(i + 1));
        }

        HandleObject resultHandleObject = handlerList.get(0).handle(new HandleObject(100.5, 40.5, Color.Green));

        System.out.println("Got an distorted object : " + resultHandleObject.toString());
    }

}
