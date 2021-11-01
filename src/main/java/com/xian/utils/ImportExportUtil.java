package com.xian.utils;

import com.alibaba.excel.EasyExcel;
import java.io.*;
import java.util.List;

public class ImportExportUtil {
    public static <T> void export(OutputStream os,T t, List<T> list) {
        // 这里 需要指定写用哪个class去读，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(os, t.getClass()).sheet(t.getClass().getSimpleName()).doWrite(list);
    }
    public static <T> void importTable(String filename, T t) throws IOException {

        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(filename, t.getClass(), new ExcelModelListener()).sheet().doRead();
    }
}
