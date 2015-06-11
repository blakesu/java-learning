package quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bsu on 2014/5/8.
 */
public class HelloJob implements Job {

    final Logger logger = LoggerFactory.getLogger(HelloJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        logger.info("Hello World");
    }
}
