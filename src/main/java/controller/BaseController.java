package controller;

import logger.RecipeFinderLogger;

/**
 * @author kissg on 2020. 05. 17.
 */
public class BaseController {
    private RecipeFinderLogger logger;

    public BaseController(RecipeFinderLogger logger) {
        this.logger = logger;
    }

    public String getElapsedTime(long elapsed) {
        StringBuilder builder = new StringBuilder();
        builder.append("Minute(s): ").append((elapsed / 1000) / 60).append("\n");
        builder.append("Second(s): ").append((elapsed / 1000) % 60);
        return builder.toString();
    }

    public RecipeFinderLogger getLogger() {
        return logger;
    }
}
