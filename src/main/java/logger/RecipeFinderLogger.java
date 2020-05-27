package logger;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author kissg on 2020. 05. 17.
 */
public class RecipeFinderLogger {
    private String filename;
    private LocalDate fileDate;

    public RecipeFinderLogger() {
        createFilename();
        createFile();
    }

    public void error(String className, String msg) {
        addRow("ERR", className, msg);
    }

    public void warning(String className, String msg) {
        addRow("WAR", className, msg);
    }

    public void info(String className, String msg) {
        addRow("INF", className, msg);
    }

    private void addRow(String level, String className, String msg) {
        String DELIMETER = "|";
        String row = level + DELIMETER + LocalDateTime.now() + DELIMETER + className + DELIMETER + "Message: " + msg;
        appendToFile(row);
    }

    private void appendToFile(String row) {
        FileWriter fw;
        if (newFileNeeded()) {
            createFilename();
            createFile();
        }
        String path = utils.Paths.getPathMyLog() + "\\" + this.filename;
        try {
            fw = new FileWriter(path, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            out.println(row);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createFile() {
        File dir = new File(utils.Paths.getPathMyLog());
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                System.out.println("Error creating log directory on computer!");
            }
        }

        File file = new File(dir, this.filename);
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    System.out.println("Error creating file: " + file.getAbsolutePath());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void createFilename() {
        this.fileDate = LocalDate.now();
        this.filename = this.fileDate + "_RecipeFinder.log";
    }

    private boolean newFileNeeded() {
        return this.fileDate.compareTo(LocalDate.now()) != 0;
    }
}
