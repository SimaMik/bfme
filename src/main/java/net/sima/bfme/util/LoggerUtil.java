package net.sima.bfme.util;

import net.sima.bfme.BFME;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
    public static final Logger LOGGER = LoggerFactory.getLogger(BFME.MOD_ID);
    private static LoggerUtil singleInstance = null;

    public static synchronized LoggerUtil getInstance() {
        if (singleInstance == null) singleInstance = new LoggerUtil();
        return singleInstance;
    }

    public LoggerUtil() {
    }

    public void logDebugMsg(String msg) {
        if(BFME.IS_DEBUG) LOGGER.info(msg);
    }

    public void logInfoMsg(String msg) {
        LOGGER.info(msg);
    }

    public static void logError(String msg) {
        LOGGER.error(msg);
    }
}