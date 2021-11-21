package com.epam.passwordManager.Utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PMTLogger {
        static Logger logger;

        private static Logger getLogger() {
            if (logger == null) {
                logger = LogManager.getLogger();
            }
            return logger;
        }



        public static void log(Level level, String msg) {
            getLogger().log(level, msg);
        }




}
