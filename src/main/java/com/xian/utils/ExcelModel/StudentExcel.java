package com.xian.utils.ExcelModel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.xian.utils.DateConverter;

import java.util.Date;

/**
 * 表格实体
 */
public class StudentExcel extends ExcelModel {

    /**
     * 第一列的数据
     */
    @ExcelProperty(index = 0)
    private String column1;
    /**
     * 第一列的数据
     */
    @ExcelProperty(index = 1)
    private String column2;/**
     * 第一列的数据
     */
    @ExcelProperty(index = 2)
    private String column3;/**
     * 第一列的数据
     */
    @ExcelProperty(index = 3)
    private String column4;/**
     * 第一列的数据
     */
    @ExcelProperty(index = 4,converter = DateConverter.class)
    private Date column5;

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    public String getColumn3() {
        return column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    public String getColumn4() {
        return column4;
    }

    public void setColumn4(String column4) {
        this.column4 = column4;
    }

    public Date getColumn5() {
        return column5;
    }

    public void setColumn5(Date column5) {
        this.column5 = column5;
    }

    @Override
    public String toString() {
        return "StudentExcel{" +
                "column1='" + column1 + '\'' +
                ", column2='" + column2 + '\'' +
                ", column3='" + column3 + '\'' +
                ", column4='" + column4 + '\'' +
                ", column5=" + column5 +
                '}';
    }
}