package codecool.learningguide.config;

import codecool.learningguide.dao.TranslationDao;
import codecool.learningguide.model.Translation;
import codecool.learningguide.step.Listener;
import codecool.learningguide.step.Processor;
import codecool.learningguide.step.Reader;
import codecool.learningguide.step.Writer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public TranslationDao translationDao;

    @Bean
    public Job job() {
        return jobBuilderFactory.get("job").incrementer(new RunIdIncrementer()).listener(new Listener(translationDao))
                .flow(step1()).end().build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").<Translation, Translation>chunk(2)
                .reader(Reader.reader("dictionary.csv"))
                .processor(new Processor()).writer(new Writer(translationDao)).build();
    }
}
