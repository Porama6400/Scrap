package net.otlg.scrap.logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ScrapVolatileLogger {

    public static final ScrapVolatileLogger CONSOLE = new ScrapVolatileLogger(null) {
        @Override
        public void logln(String message) {
            System.out.println(message);
        }

        @Override
        public void close() {
        }
    };
    public static final ScrapVolatileLogger NOP = new ScrapVolatileLogger(null) {
        @Override
        public void logln(String message) {

        }

        @Override
        public void close() {
        }
    };

    private BufferedWriter bufferedWriter;

    public ScrapVolatileLogger(File file) {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
        } catch (Exception ignored) {
        }
    }

    public void logln(String message) {
        try {
            bufferedWriter.write(message);
            bufferedWriter.write('\n');
        } catch (Exception ignored) {
        }
    }

    public void log(String message) {
        try {
            bufferedWriter.write(message);
        } catch (Exception ignored) {
        }
    }

    public void close() {
        try {
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception ignored) {
        }
    }


    @Override
    protected void finalize() throws Throwable {
        close();
    }

    public void flush() {
        try {
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
