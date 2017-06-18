package codecool.learningguide.dao;

import codecool.learningguide.model.Translation;

import java.util.List;

public interface TranslationDao {

    void insert(Translation trans);

    void insertBatch(List<Translation> dictionaries);

    List<Translation> loadAllTranslation();

    Translation findTranslationById(int trans_id);

    String findHungarianById(int trans_id);

    String findForeignById(int trans_id);

    int getTotalNumberTranslation();
}
