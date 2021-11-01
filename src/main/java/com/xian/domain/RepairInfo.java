package com.xian.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Xian
 */
@Data
public class RepairInfo {
    @ExcelProperty("编号")
    private Integer id;
    @ExcelProperty("宿舍编号")
    private Integer do_id;
    @ExcelProperty("维修时间")
    private Date repairDate;
}
