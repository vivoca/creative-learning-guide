package codecool.learningguide.service;

import codecool.learningguide.model.Translation;

import java.util.List;
import java.util.Set;

public interface ExerciseService {

    List<Translation> getExeOneAnswer(int questionId);

    Translation getExeOneQuestion();
}
