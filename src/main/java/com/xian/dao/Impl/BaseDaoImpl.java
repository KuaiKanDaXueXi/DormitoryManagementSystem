package com.xian.dao.Impl;

import com.xian.dao.BaseDao;
import com.xian.utils.DaoUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class BaseDaoImpl extends DaoUtil implements BaseDao {
    @Override
    public List query(String sql, RowMapper rowMapper) {
        try {
            System.out.println(template.query(sql,rowMapper));
            return template.query(sql,rowMapper);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int modify(String sql) {
        return template.update(sql);
    }
}
