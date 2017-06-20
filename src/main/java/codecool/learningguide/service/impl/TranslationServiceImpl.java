package codecool.learningguide.service.impl;

import codecool.learningguide.dao.TranslationDao;
import codecool.learningguide.model.Translation;
import codecool.learningguide.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranslationServiceImpl implements TranslationService {

    @Autowired
    TranslationDao translationDao;

    @Override
    public void insert(Translation trans) {
        translationDao.insert(trans);
    }

    @Override
    public void insertBatch(List<Translation> dictionaries) {
        translationDao.insertBatch(dictionaries);
    }

    public List<Translation> getAllTranslation(){
        return translationDao.getAllTranslation();
    }

    @Override
    public Translation getTranslationById(int trans_id) {
        return translationDao.findTranslationById(trans_id);
    }

    @Override
    public String getHungarianById(int trans_id) {
        return translationDao.findHungarianById(trans_id);
    }

    @Override
    public void getForeignById(int trans_id) {
        String foreign = translationDao.findForeignById(trans_id);
        System.out.println("Foreign translation = " + foreign);
    }

    @Override
    public void getTotalNumberTranslation() {
        int totalNumberTranslation = translationDao.getTotalNumberTranslation();
        System.out.println("Total Number Translation is: " + totalNumberTranslation);
    }
}
