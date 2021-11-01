package com.xian.utils.row;

import com.xian.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Xian
 */
public class UserRow implements RowMapper, Serializable {
    @Override
    public com.xian.domain.User mapRow(ResultSet rs, int rowNumber) throws SQLException {
        com.xian.domain.User user = new com.xian.domain.User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setPower(rs.getInt("power"));
        user.setState(rs.getInt("state"));
        return user;
    }
}
