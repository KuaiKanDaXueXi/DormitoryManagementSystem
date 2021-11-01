package com.xian.utils;

import org.apache.commons.beanutils.ConvertUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class ReqConvertUtil {
    public static <T> T convert(T t, HttpServletRequest req) throws Exception {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            String methodname = field.getName();
            String parameter = req.getParameter(methodname);
            methodname = methodname.substring(0,1).toUpperCase(Locale.ROOT)+methodname.substring(1);
            Method method = t.getClass().getDeclaredMethod("set" + methodname, field.getType());
            if ("interface java.util.List".equals(field.getType()+"")){
                method.invoke(t, (Object) null);
            }else{
                method.invoke(t, ConvertUtils.convert(parameter,field.getType()));
            }
        }
        return t;
    }
}
