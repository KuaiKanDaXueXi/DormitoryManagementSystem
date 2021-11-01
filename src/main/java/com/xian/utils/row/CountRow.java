package com.xian.utils.row;

import com.xian.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Xian
 */
public class CountRow implements RowMapper, Serializable {
    @Override
    public Integer mapRow(ResultSet rs, int rowNumber) throws SQLException {
        return rs.getInt("count(0)");
    }
}
