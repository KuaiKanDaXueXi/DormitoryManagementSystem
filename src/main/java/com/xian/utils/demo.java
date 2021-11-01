package com.xian.utils;

import com.xian.domain.User;
import com.xian.utils.ExcelModel.UserExcel;

public class demo {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println(Class.forName("com.xian.utils.ExcelModel.UserExcel").newInstance());
    }
}
