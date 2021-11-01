package com.xian.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xian.domain.PageBean;
import com.xian.domain.User;
import com.xian.domain.UserLogin;
import com.xian.service.UserService;
import com.xian.utils.ExcelModel.ExcelModel;
import com.xian.utils.ExcelModel.UserExcel;
import com.xian.utils.row.CountRow;
import com.xian.utils.row.UserRow;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * @author Xian
 */
public class UserServiceImpl implements UserService {

    @Override
    public String queryByPage(PageBean pageBean) throws JsonProcessingException {
        int rows = pageBean.getRows();
        int start = (pageBean.getCurrentPage()-1)*rows;
        String sql = "select count(0) from user_tb";
        List counts = bd.query(sql, new CountRow());
        int totalcount = (int) counts.get(0);
        pageBean.setTotalCount(totalcount);
        pageBean.setTotalPage((int) (Math.ceil(totalcount*1.0/pageBean.getRows())));
        sql = "select * from user_tb limit "+start+","+rows;
        pageBean.setList(bd.query(sql,new UserRow()));
        return new ObjectMapper().writeValueAsString(pageBean);
    }

    @Override
    public<T> List<T> queryAll(T t) {
        String sql = "select * from user_tb";
        return bd.query(sql,new UserRow());
    }

    @Override
    public void insertUser(ExcelModel excelModel) {
        UserExcel userExcel = (UserExcel) excelModel;
        String sql = "insert into user_tb values(null,'"+userExcel.getColumn1()+"',default,default,default)";
        System.out.println(sql);
        bd.modify(sql);
    }

    @Override
    public UserLogin loginUser(String username, String password) {
        UserLogin userLogin = null;
        String sql = "select * from user_tb where username = '"+username+"' and state = 1";
        List<User> query = bd.query(sql, new UserRow());
        if (query!=null&&query.size()>0) {
            if (query.get(0).getPassword().equals(password)){
                userLogin.setUsername(username);
                userLogin.setState(1);
                userLogin.setId(query.get(0).getId());
                userLogin.setPower(query.get(0).getPower());
            };
        }
        return userLogin;
    }
}
