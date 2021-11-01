package com.xian.dao;

import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public interface BaseDao {
    public List query(String sql, RowMapper rowMapper);
    public int modify(String sql);
}
