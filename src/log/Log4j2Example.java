package log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Example {

	    public static void main(String[] args) {
	    	System.setProperty("log4j.configurationFile","./src/log/log4j2.xml");
	    	Logger logger = LogManager.getRootLogger();
 
	    	logger.error("testing ERROR level");
	    	logger.debug("testing ERROR level");
	    	logger.info("testing ERROR level");
	    	logger.trace("testing ERROR level");
	    	
	    }
}

