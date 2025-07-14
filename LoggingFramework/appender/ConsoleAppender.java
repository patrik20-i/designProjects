package LoggingFramework.appender;

import LoggingFramework.LogMessage;
import LoggingFramework.formatter.LogFormatter;

public class ConsoleAppender implements LogAppender{
    private final LogFormatter formatter;

    public ConsoleAppender(LogFormatter formatter){
        this.formatter = formatter;
    }
    public void append(LogMessage message){
        System.out.println(formatter.format(message));
    }
}
