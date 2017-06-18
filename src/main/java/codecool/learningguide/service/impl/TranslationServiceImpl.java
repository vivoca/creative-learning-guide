package codecool.learningguide.service.impl;

import codecool.learningguide.dao.TranslationDao;
import codecool.learningguide.model.Translation;
import codecool.learningguide.service.TranslationService;
import com.sun.org.apache.xpath.internal.SourceTree;
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

    public void loadAllTranslation(){
        List<Translation> listTrans = translationDao.loadAllTranslation();
        for(Translation trans: listTrans){
            System.out.println(trans.toString());
        }
    }

    @Override
    public void getTranslationById(int trans_id) {
        Translation trans = translationDao.findTranslationById(trans_id);
        System.out.println(trans);
    }

    @Override
    public void getHungarianById(int trans_id) {
        String hungarian = translationDao.findHungarianById(trans_id);
        System.out.println("Hungarian translation = " + hungarian);
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
