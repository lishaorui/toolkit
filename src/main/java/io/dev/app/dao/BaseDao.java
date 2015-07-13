package io.dev.app.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * desc:
 * 
 * @author lsr
 * @version 2014年5月14日
 */
@Repository
public class BaseDao<T> {
	private static final Logger logger = LoggerFactory.getLogger(BaseDao.class);
	
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void update(String sql, Object... args) {
    	logger.debug("#update sql:{}, params:{}", sql, args);
    	jdbcTemplate.update(sql, args);
        
    }

    public T queryByPrimaryKey(String sql, Object[] args, RowMapper<T> rowMapper) {
    	logger.debug("#queryByPrimaryKey sql:{}, params:{}", sql, args);
        return jdbcTemplate.queryForObject(sql, args, rowMapper);
    }

    public List<T> query(String sql, RowMapper<T> rowMapper) {
    	logger.debug("#query sql:{}", sql);
        return jdbcTemplate.query(sql, rowMapper);
    }

    public List<T> query(String sql, Object[] args, RowMapper<T> rowMapper) {
    	logger.debug("#query sql:{}, params:{}", sql, args);
        return jdbcTemplate.query(sql, args, rowMapper);
    }
    
    public long count(String sql){
    	logger.debug("#count sql:{}", sql);
    	return jdbcTemplate.queryForObject(sql, Long.class);
    }
    
    public long count(String sql, Object... args){
    	logger.debug("#count sql:{}, params:{}", sql, args);
    	return jdbcTemplate.queryForObject(sql, args, Long.class);
    }
    
    public Object sum(String sql){
        logger.debug("#sum sql:{}", sql);
        return jdbcTemplate.queryForObject(sql, Object.class);
    }
    
    public Object sum(String sql, Object... args){
        logger.debug("#sum sql:{}, params:{}", sql, args);
        return jdbcTemplate.queryForObject(sql, args, Object.class);
    }
    
}
