package com.xian.dao;

import com.xian.domain.UserLogin;

public interface LoginDao {
    public UserLogin query(String sql);
}
