package LoggingFramework;

public enum LogLevel {
    DEBUG,
    INFO,
    WARNING,
    ERROR,
    FATAL;

    public boolean isSevereAs(LogLevel other){
        return this.ordinal()>=other.ordinal();
    }
}
