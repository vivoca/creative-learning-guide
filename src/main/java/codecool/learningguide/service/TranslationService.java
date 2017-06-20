package codecool.learningguide.service;

import codecool.learningguide.model.Translation;
import java.util.List;

public interface TranslationService {

    void insert(Translation trans);

    void insertBatch(List<Translation> dictionaries);

    List<Translation> getAllTranslation();

    Translation getTranslationById(int trans_id);

    String getHungarianById(int trans_id);

    void getForeignById(int trans_id);

    void getTotalNumberTranslation();
}
