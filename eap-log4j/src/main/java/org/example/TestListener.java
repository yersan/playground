package org.example;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author <a href="mailto:yborgess@redhat.com">Yeray Borges</a>
 */
@javax.servlet.annotation.WebListener
public class TestListener implements ServletContextListener {
    final Logger logger = LogManager.getLogger(TestListener.class);

    public void contextInitialized(ServletContextEvent event) {
        System.out.println("------------------------------ contextInitialized");
//
//        LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
//        File file = new File("/tmp/log4j2.xml");
//        // this will force a reconfiguration
//        context.setConfigLocation(file.toURI());

        logger.info("------------------------------ contextInitialized");
    }

    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("------------------------------ contextDestroyed");
        logger.info("------------------------------ contextDestroyed");
    }
}