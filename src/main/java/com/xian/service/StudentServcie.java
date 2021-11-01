package com.xian.service;

import com.xian.dao.BaseDao;
import com.xian.dao.Impl.BaseDaoImpl;
import com.xian.utils.ExcelModel.ExcelModel;

public interface StudentServcie {
    BaseDao bd = new BaseDaoImpl();
    public void insertStudent(ExcelModel excelModel);
}
