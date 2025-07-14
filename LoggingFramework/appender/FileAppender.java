package LoggingFramework.appender;

import java.io.FileWriter;
import java.io.IOException;

import LoggingFramework.LogMessage;
import LoggingFramework.formatter.LogFormatter;

public class FileAppender implements LogAppender {
    private final LogFormatter formatter;
    private FileWriter writer;

    public FileAppender(String filePath, LogFormatter formatter){
        this.formatter = formatter;
        try{
            this.writer = new FileWriter(filePath, true);
        }
        catch(Exception e){
            System.out.println("failed to create a writer for logs"+ e.getMessage());
        }
    }
    @Override
    public synchronized void append(LogMessage message){
        try {
            writer.write(formatter.format(message) + "\n");
            writer.flush();
        } 
        catch (IOException e) {
            System.out.println("Failed to write logs to file, exception: " + e.getMessage());
        }
    }

}

