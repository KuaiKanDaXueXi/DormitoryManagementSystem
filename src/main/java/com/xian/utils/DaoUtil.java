package com.xian.utils;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Xian
 */
public class DaoUtil {
    protected static JdbcTemplate template= new JdbcTemplate(DbUtil.getDataSource());
}
