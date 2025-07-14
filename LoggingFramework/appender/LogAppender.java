package LoggingFramework.appender;

import LoggingFramework.LogMessage;

public interface LogAppender {
    void append(LogMessage message);
}
