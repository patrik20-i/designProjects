package LoggingFramework;

public class LogMessage {
    private final LogLevel logLevel;
    private final String message;
    private final long timestamp;
    private final String threadName;

    public LogMessage(LogLevel level, String message, long time, String thread){
        this.logLevel = level;
        this.message = message;
        this.timestamp = time;
        this.threadName = thread;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public String getMessage() {
        return message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getThreadName() {
        return threadName;
    }
}
