package codecool.learningguide.step;

import codecool.learningguide.model.Translation;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;


public class Reader {
    public static FlatFileItemReader<Translation> reader(String path) {
        FlatFileItemReader<Translation> reader = new FlatFileItemReader<Translation>();

        reader.setResource(new ClassPathResource(path));
        reader.setLineMapper(new DefaultLineMapper<Translation>() {
            {
                setLineTokenizer(new DelimitedLineTokenizer() {
                    {
                        setNames(new String[] { "id", "hungarian", "foreign" });
                    }
                });
                setFieldSetMapper(new BeanWrapperFieldSetMapper<Translation>() {
                    {
                        setTargetType(Translation.class);
                    }
                });
            }
        });
        return reader;
    }
}
