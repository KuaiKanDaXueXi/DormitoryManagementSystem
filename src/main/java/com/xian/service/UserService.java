package com.xian.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xian.dao.BaseDao;
import com.xian.dao.Impl.BaseDaoImpl;
import com.xian.dao.Impl.LoginDaoImpl;
import com.xian.dao.LoginDao;
import com.xian.domain.PageBean;
import com.xian.domain.User;
import com.xian.domain.UserLogin;
import com.xian.utils.ExcelModel.ExcelModel;

import java.util.List;

/**
 * @author Xian
 */
public interface UserService {
    BaseDao bd = new BaseDaoImpl();
    LoginDao ld = new LoginDaoImpl();
    public String queryByPage(PageBean<User> pageBean) throws JsonProcessingException;
    public<T> List<T> queryAll(T t);
    public void insertUser(ExcelModel excelModel);
    public UserLogin loginUser(String username,String password);
}
