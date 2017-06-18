package codecool.learningguide.step;

import java.util.List;

import codecool.learningguide.dao.TranslationDao;
import codecool.learningguide.model.Translation;
import org.springframework.batch.item.ItemWriter;


public class Writer implements ItemWriter<Translation> {

    private final TranslationDao transDao;

    public Writer(TranslationDao transDao) {
        this.transDao = transDao;
    }

    @Override
    public void write(List<? extends Translation> translations) throws Exception {
        transDao.insertFromCsv(translations);
    }
}
