package LoggingFramework.formatter;

import LoggingFramework.LogMessage;

public interface LogFormatter {
    String format(LogMessage message);
}