package com.xian.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.xian.service.Impl.StudentServcieImpl;
import com.xian.service.Impl.UserServiceImpl;
import com.xian.utils.ExcelModel.ExcelModel;
import com.xian.utils.ExcelModel.UserExcel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/***
 *  监听器
 * @author Xian
 */
public class ExcelModelListener extends AnalysisEventListener<ExcelModel> {

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理l ist ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<ExcelModel> list = new ArrayList<>();
    private static int count = 1;

    @Override
    public void invoke(ExcelModel excelModel, AnalysisContext analysisContext) {
        list.add(excelModel);
        count ++;
        if (list.size() >= BATCH_COUNT) {
            saveData( count,list.get(0).getClass() );
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData( count,list.get(0).getClass() );
        System.out.println("所有数据解析完成！");
        System.out.println(" count ：" + count);
    }

    /**
     * 加上存储数据库
     */
    private void saveData(int count,Class<?> t) {
        Class<?> service = getService(t);
        String simpleName = service.getSimpleName();
        try {
            String methodName = "insert" + simpleName;
            methodName = methodName.substring(0,methodName.length()-11);
            Method method = service.getDeclaredMethod(methodName, ExcelModel.class);
            for (int i = 0; i <count-1;i++) {
                System.out.println(list);
                System.out.println(list.size()+","+i+","+count);
                method.invoke(service.newInstance(),list.get(i));
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    private Class<?> getService(Class<?> t){
        String classname = t.getSimpleName();
        System.out.println(classname);
        switch (classname) {
            case "UserExcel":{
                return UserServiceImpl.class;
            }
            case "StudentExcel":{
                return StudentServcieImpl.class;
            }
            default:
                return null;
        }
    }

}