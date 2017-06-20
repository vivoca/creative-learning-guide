package codecool.learningguide;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;



@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class Main extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Main.class);
    }

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @RequestMapping("/runjob")
    public String handle() throws Exception {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        try {
            JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(job, jobParameters);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return "Done! Check Console Window for more details";
    }

}