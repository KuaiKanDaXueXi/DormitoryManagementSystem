package com.xian.utils.row;

import com.xian.domain.Stu_Do;
import com.xian.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Xian
 */
public class Stu_DoRow implements RowMapper, Serializable {
    @Override
    public Stu_Do mapRow(ResultSet rs, int rowNumber) throws SQLException {
        Stu_Do sd = new Stu_Do();
        sd.setId(rs.getInt("id"));
        sd.setDo_id(rs.getInt("do_id"));
        sd.setStu_id(rs.getInt("stu_id"));
        return sd;
    }
}
