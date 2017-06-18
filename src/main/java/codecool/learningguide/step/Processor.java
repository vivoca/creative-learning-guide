package codecool.learningguide.step;

import codecool.learningguide.model.Translation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;


public class Processor implements ItemProcessor<Translation, Translation> {

    private static final Logger log = LoggerFactory.getLogger(Processor.class);

    @Override
    public Translation process(Translation trans) throws Exception {

        final int id = trans.getTransId();
        final String hungarian = trans.getHungarian().toUpperCase();
        final String foreign = trans.getForeign().toUpperCase();

        final Translation fixedTrans = new Translation(id, hungarian, foreign);

        log.info("Converting (" + trans + ") into (" + fixedTrans + ")");

        return fixedTrans;
    }
}
