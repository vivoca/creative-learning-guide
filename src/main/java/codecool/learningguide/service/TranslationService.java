package codecool.learningguide.service;

import codecool.learningguide.model.Translation;

import java.util.List;

public interface TranslationService {

    void insert(Translation trans);

    void insertBatch(List<Translation> dictionaries);

    void loadAllTranslation();

    void getTranslationById(int trans_id);

    void getHungarianById(int trans_id);

    void getForeignById(int trans_id);

    void getTotalNumberTranslation();
}
