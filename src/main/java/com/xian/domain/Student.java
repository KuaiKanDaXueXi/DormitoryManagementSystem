package com.xian.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Xian
 */
@Data
public class Student {
    @ExcelProperty("编号")
    private Integer id;
    @ExcelProperty("学号")
    private String stu_numb;
    @ExcelProperty("姓名")
    private String stu_name;
    @ExcelProperty("性别")
    private String stu_gender;
    @ExcelProperty("学院")
    private String stu_col;
    @ExcelProperty("入住时间")
    private Date in_time;
}
