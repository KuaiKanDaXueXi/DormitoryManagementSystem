package com.xian.utils.row;

import com.xian.domain.Student;
import com.xian.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Xian
 */
public class StudentRow implements RowMapper, Serializable {
    @Override
    public Student mapRow(ResultSet rs, int rowNumber) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setStu_numb(rs.getString("stu_numb"));
        student.setStu_name(rs.getString("stu_name"));
        student.setStu_gender(rs.getString("stu_gender"));
        student.setStu_col(rs.getString("stu_col"));
        student.setIn_time(rs.getDate("in_time"));
        return student;
    }
}
