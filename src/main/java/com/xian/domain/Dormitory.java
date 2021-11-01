package com.xian.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author Xian
 */
@Data
public class Dormitory {
    @ExcelProperty("宿舍编号")
    private  Integer id;
    @ExcelProperty("宿舍号")
    private String do_num;
    @ExcelProperty("楼层")
    private Integer do_flo;
    @ExcelProperty("宿舍容量")
    private Integer do_cap;
    @ExcelProperty("宿舍电量")
    private Integer do_el_charge;
    @ExcelIgnore
    private Integer do_el_switch;
}
