package codecool.learningguide.service;

import codecool.learningguide.model.Translation;
import java.util.Set;

public interface ExerciseService {

    Set<Translation> getExeOneAnswer(int questionId);

    Translation getExeOneQuestion();
}
