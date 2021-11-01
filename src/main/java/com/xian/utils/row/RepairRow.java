package com.xian.utils.row;

import com.xian.domain.RepairInfo;
import com.xian.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Xian
 */
public class RepairRow implements RowMapper, Serializable {
    @Override
    public RepairInfo mapRow(ResultSet rs, int rowNumber) throws SQLException {
        RepairInfo repairInfo = new RepairInfo();
        repairInfo.setId(rs.getInt("id"));
        repairInfo.setDo_id(rs.getInt("do_id"));
        repairInfo.setRepairDate(rs.getDate("repairDate"));
        return repairInfo;
    }
}
