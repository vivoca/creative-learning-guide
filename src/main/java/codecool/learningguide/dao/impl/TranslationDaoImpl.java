package codecool.learningguide.dao.impl;

import codecool.learningguide.dao.TranslationDao;
import codecool.learningguide.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class TranslationDaoImpl extends JdbcDaoSupport implements TranslationDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public void insert(Translation trans) {
        String sql = "INSERT INTO translation " + "(TRANS_ID, HUNGARIAN, OTHER) VALUES (?, ?, ?)" ;
        getJdbcTemplate().update(sql, new Object[]{
                trans.getTransId(), trans.getHungarian(), trans.getForeign()
        });
    }

    @Override
    public void insertBatch(final List<Translation> dictionaries) {
        String sql = "INSERT INTO translation " + "(TRANS_ID, HUNGARIAN, OTHER) VALUES (?, ?, ?)" ;
        getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Translation translation = dictionaries.get(i);
                ps.setInt(1, translation.getTransId());
                ps.setString(2, translation.getHungarian());
                ps.setString(3, translation.getForeign());
            }

            public int getBatchSize() {
                return dictionaries.size();
            }
        });

    }

    public List<Translation> loadAllTranslation(){
        String sql = "SELECT * FROM translation";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Translation> result = new ArrayList<Translation>();
        for(Map<String, Object> row:rows){
            Translation trans = new Translation();
            trans.setTransId((Integer)row.get("trans_id"));
            trans.setHungarian((String)row.get("hungarian"));
            trans.setForeign((String) row.get("other"));
            result.add(trans);
        }

        return result;
    }

    @Override
    public Translation findTranslationById(int trans_id) {
        String sql = "SELECT * FROM translation WHERE TRANS_ID = ?";
        return (Translation)getJdbcTemplate().queryForObject(sql, new Object[]{trans_id}, new RowMapper<Translation>(){
            @Override
            public Translation mapRow(ResultSet rs, int rwNumber) throws SQLException {
                Translation trans = new Translation();
                trans.setTransId(rs.getInt("trans_id"));
                trans.setHungarian(rs.getString("hungarian"));
                trans.setForeign(rs.getString("foreign"));
                return trans;
            }
        });
    }

    @Override
    public String findHungarianById(int trans_id) {
        String sql = "SELECT hungarian FROM translation WHERE trans_id = ?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{trans_id}, String.class);
    }

    @Override
    public String findForeignById(int trans_id) {
        String sql = "SELECT other FROM translation WHERE trans_id = ?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{trans_id}, String.class);
    }

    @Override
    public int getTotalNumberTranslation() {
        String sql = "SELECT Count(*) FROM translation";
        int total = getJdbcTemplate().queryForObject(sql, Integer.class);
        return total;
    }
}
