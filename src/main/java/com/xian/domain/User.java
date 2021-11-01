package com.xian.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class User {
    @ExcelProperty("编号")
    private Integer id;
    @ExcelProperty("账户")
    private String username;
    @ExcelIgnore
    private String password;
    @ExcelIgnore
    private Integer power;
    @ExcelIgnore
    private Integer state;
}
