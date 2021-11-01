package com.xian.utils;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.CellData;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


/**
 * @ClassName LocalDateTimeConverter
 * @Description EasyExcel LocalDateTime转换器
 * @Author amx
 * @Date 2020/9/17 6:10 下午
 **/
public class DateConverter implements Converter<LocalDateTime> {

    private static final String DEFAULT_PATTERN = "yyyy-MM-dd";
    @Override
    public Class supportJavaTypeKey() {
        return null;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return null;
    }

    @Override
    public LocalDateTime convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DEFAULT_PATTERN);
        LocalDate localDate = LocalDate.parse(cellData.getStringValue(),dateTimeFormatter);
        LocalDateTime localDateTime = LocalDateTime.of(localDate, LocalTime.of(00,00));
        return localDateTime;
    }

    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<LocalDateTime> context) throws Exception {
        return null;
    }
}