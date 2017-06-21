package codecool.learningguide.service.impl;

import codecool.learningguide.model.Translation;
import codecool.learningguide.service.ExerciseService;
import codecool.learningguide.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    TranslationService translationService;

    @Override
    public List<Translation> getExeOneAnswer(int questionId) {
        List<Translation> result = new ArrayList<Translation>();
        result.add(translationService.getTranslationById(questionId));
        while (result.size() < 4) {
            Random rand = new Random();
            int transId = rand.nextInt((5 - 1) + 1) + 1;
            boolean contained = false;
            for (Translation element : result) {
                if (element.compareTo(translationService.getTranslationById(transId)) == 0) {
                    contained = true;
                }
            }
            if (!contained) {
                result.add(translationService.getTranslationById(transId));
            }
        }
        Collections.shuffle(result);
        return result;
    }

    @Override
    public Translation getExeOneQuestion() {
        Random rand = new Random();
        int questionId = rand.nextInt((5 - 1) + 1) + 1;
        return translationService.getTranslationById(questionId);
    }
}
