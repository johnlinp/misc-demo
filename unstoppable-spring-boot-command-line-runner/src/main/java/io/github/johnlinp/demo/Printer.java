package io.github.johnlinp.demo;

import java.io.Closeable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Printer implements Closeable
{
    private static final Logger logger = LogManager.getLogger();

    private final Thread thread;

    private boolean shouldStop = false;

    public Printer ()
    {
        logger.info("Printer constructor");
        thread = new Thread(new InnerPrinter());
        thread.start();
    }

    @Override
    public void close ()
    {
        logger.info("Printer close");
        shouldStop = true;
    }

    private class InnerPrinter implements Runnable
    {
        @Override
        public void run ()
        {
            for (int idx = 0; !shouldStop; ++idx) {
                logger.info("InnerPrinter idx: " + idx);
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }
}
