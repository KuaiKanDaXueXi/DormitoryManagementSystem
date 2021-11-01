package com.xian.utils.row;

import com.xian.domain.UserLogin;
import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Xian
 */
public class UserLoginRow implements RowMapper, Serializable {
    @Override
    public UserLogin mapRow(ResultSet rs, int rowNumber) throws SQLException {
        UserLogin userlogin = new UserLogin();
        userlogin.setId(rs.getInt("id"));
        userlogin.setUsername(rs.getString("username"));
        userlogin.setPower(rs.getInt("power"));
        userlogin.setState(rs.getInt("status"));
        return userlogin;
    }
}
