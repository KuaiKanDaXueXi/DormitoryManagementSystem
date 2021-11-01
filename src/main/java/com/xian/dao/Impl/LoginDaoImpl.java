package com.xian.dao.Impl;

import com.xian.dao.BaseDao;
import com.xian.dao.LoginDao;
import com.xian.domain.User;
import com.xian.domain.UserLogin;
import com.xian.utils.DaoUtil;
import com.xian.utils.row.UserRow;

import java.util.List;

public class LoginDaoImpl extends DaoUtil implements LoginDao {
    BaseDao db = new BaseDaoImpl();
    @Override
    public UserLogin query(String sql) {
        List<User> user = db.query(sql, new UserRow());
        if (user.size()>0){
            UserLogin userLogin = new UserLogin();
            userLogin.setId(user.get(0).getId());
            userLogin.setUsername(user.get(0).getUsername());
            userLogin.setPower(user.get(0).getPower());
            userLogin.setState(user.get(0).getState());
            return userLogin;
        }
        return null;
    }
}
