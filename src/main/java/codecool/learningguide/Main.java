package codecool.learningguide;


import codecool.learningguide.model.Translation;
import codecool.learningguide.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class Main implements CommandLineRunner {


    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @Autowired
    TranslationService transService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {


        Translation trans_1 = new Translation();
        int trans_1_id = 1;
        trans_1.setTransId(trans_1_id);
        trans_1.setHungarian("talán");
        trans_1.setForeign("vielleicht");

        Translation trans_2 = new Translation();
        int trans_2_id = 2;
        trans_2.setTransId(trans_2_id);
        trans_2.setHungarian("mindig");
        trans_2.setForeign("immer");

        Translation trans_3 = new Translation();
        int trans_3_id = 3;
        trans_3.setTransId(trans_3_id);
        trans_3.setHungarian("tegnap");
        trans_3.setForeign("gestern");

        // Insert a customer to DB
        transService.insert(trans_1);


//        // Insert a List of Customer to DB
        List<Translation> translations = new ArrayList<Translation>();
        translations.add(trans_2);
        translations.add(trans_3);
        transService.insertBatch(translations);

        // Load All Customer and display
        transService.loadAllTranslation();

    }
}