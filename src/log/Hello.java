package log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hello {
  static final Logger logger = LogManager.getLogger(Hello.class.getName());

  public boolean callMe() {
    logger.entry();
    logger.error("Inside Hello Logger!");
    return logger.exit(false);
  }
}