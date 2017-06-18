package codecool.learningguide.step;

import java.util.List;

import codecool.learningguide.dao.TranslationDao;
import codecool.learningguide.model.Translation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;


public class Listener extends JobExecutionListenerSupport {
    private static final Logger log = LoggerFactory.getLogger(Listener.class);

    private final TranslationDao translationDao;

    public Listener(TranslationDao translationDao) {
        this.translationDao = translationDao;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("Finish Job! Check the results");

            List<Translation> translations = translationDao.loadAllTranslation();

            for (Translation translation : translations) {
                log.info("Found <" + translation + "> in the database.");
            }
        }
    }
}

