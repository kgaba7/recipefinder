package controller;

/**
 * @author kissg on 2020. 05. 17.
 */
public class BaseController {
    public String getElapsedTime(long elapsed) {
        StringBuilder builder = new StringBuilder();
        builder.append("Minute(s): ").append((elapsed / 1000) / 60).append("\n");
        builder.append("Second(s): ").append((elapsed / 1000) % 60);
        return builder.toString();
    }

}
