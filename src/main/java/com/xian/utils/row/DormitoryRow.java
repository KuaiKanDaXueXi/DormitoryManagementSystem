package com.xian.utils.row;

import com.xian.domain.Dormitory;
import com.xian.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Xian
 */
public class DormitoryRow implements RowMapper, Serializable {
    @Override
    public Dormitory mapRow(ResultSet rs, int rowNumber) throws SQLException {
        Dormitory dormitory = new Dormitory();
        dormitory.setId(rs.getInt("id"));
        dormitory.setDo_num(rs.getString("do_num"));
        dormitory.setDo_flo(rs.getInt("do_flo"));
        dormitory.setDo_cap(rs.getInt("do_cap"));
        dormitory.setDo_el_charge(rs.getInt("do_el_charge"));
        dormitory.setDo_el_switch(rs.getInt("do_el_switch"));
        return dormitory;
    }
}
