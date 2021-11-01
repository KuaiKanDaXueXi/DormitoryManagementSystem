package com.xian.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author Xian
 */
@Data
public class Stu_Do {
    @ExcelProperty("编号")
    private Integer id;
    @ExcelProperty("宿舍编号")
    private Integer do_id;
    @ExcelProperty("学生编号")
    private Integer stu_id;
}
