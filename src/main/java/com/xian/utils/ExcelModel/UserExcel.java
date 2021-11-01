package com.xian.utils.ExcelModel;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 表格实体
 */
public class UserExcel extends ExcelModel {

    /**
     * 第一列的数据
     */
    @ExcelProperty(index = 0)
    private String column1;

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn1() {
        return column1;
    }

    @Override
    public String toString() {
        return "UserExcel{" +
                "column1='" + column1 + '\'' +
                '}';
    }
}