package codecool.learningguide.service.impl;

import codecool.learningguide.model.Translation;
import codecool.learningguide.service.ExerciseService;
import codecool.learningguide.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    TranslationService translationService;

    @Override
    public Set<Translation> getExeOneAnswer(int questionId) {
        Set<Translation> result = new HashSet<Translation>();
        Random ran = new Random();
        while (result.size() < 4) {
            int transId = ran.nextInt(1) + 5;
            result.add(translationService.getTranslationById(transId));
        }
        return result;
    }

    @Override
    public Translation getExeOneQuestion() {
        Random ran = new Random();
        int questionId = ran.nextInt(1) + 5;
        return translationService.getTranslationById(questionId);
    }
}
