package com.xian.service.Impl;

import com.xian.service.StudentServcie;
import com.xian.utils.ExcelModel.ExcelModel;
import com.xian.utils.ExcelModel.StudentExcel;
import com.xian.utils.ExcelModel.UserExcel;

public class StudentServcieImpl implements StudentServcie {
    @Override
    public void insertStudent(ExcelModel excelModel) {
        StudentExcel studentExcel = (StudentExcel) excelModel;
        String sql = "insert into user_tb values(null,'"+studentExcel.getColumn1()+"','"+studentExcel.getColumn2()+"','"+studentExcel.getColumn3()+"','"+studentExcel.getColumn4()+"','"+studentExcel.getColumn5()+"')";
        bd.modify(sql);
    }
}
