package utilities;


import org.slf4j.helpers.MessageFormatter;

import java.util.logging.Logger;

public class TapException extends RuntimeException {
    private static final Logger logger = Logger.getLogger(String.valueOf(TapException.class));

    public TapException(TapExceptionType tapExceptionType, String message, Object... args) {
        super(MessageFormatter.arrayFormat(message, args).getMessage());
        logger.info("handling vn.pops.tap.exception " + tapExceptionType);
    }
}