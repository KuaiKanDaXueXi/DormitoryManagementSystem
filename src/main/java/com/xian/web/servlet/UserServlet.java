package com.xian.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xian.domain.PageBean;
import com.xian.domain.Result;
import com.xian.domain.User;
import com.xian.domain.UserLogin;
import com.xian.service.Impl.UserServiceImpl;
import com.xian.service.UserService;
import com.xian.utils.CheckCodeUtil;
import com.xian.utils.ImportExportUtil;
import com.xian.utils.ReqConvertUtil;
import com.xian.web.servlet.BaseServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Locale;

/**
 * @author xian
 * @date 2021/10/22 19:55
 */
@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {
    UserService us = new UserServiceImpl();
    public void checkcode(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        resp.setHeader("Pramga","No-cache");
        resp.setHeader("Cache-Control","No-cache");
        resp.setDateHeader("Expires",0);
        resp.setContentType("img/jepg");
        String code = CheckCodeUtil.generateVerifyCode(4);
        req.getSession().setAttribute("code",code);
        int width =100;
        int height = 40;
        CheckCodeUtil.outputImage(width,height,resp.getOutputStream(),code);
    }
    public void getUserByPage(HttpServletRequest req,HttpServletResponse resp) {
        try {
            PageBean<User> upb = ReqConvertUtil.convert(new PageBean<User>(), req);
            String json  = us.queryByPage(upb);
            resp.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void downloadTable(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = us.queryAll(new User());
        ImportExportUtil.export(resp.getOutputStream(), new User(), users);
        req.setAttribute("filename","UserInformation.xlsx");
        req.getRequestDispatcher("/download").forward(req,resp);
    }
    public boolean veryifcode(String code,HttpSession session) {
        boolean ret = false;
        if ((code.toLowerCase(Locale.ROOT)).equals(session.getAttribute("code").toString().toLowerCase(Locale.ROOT))){
            ret = true;
            session.removeAttribute("code");
        }
        return ret;
    }
    public void logincheck(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        Result result = null;
        HttpSession session = req.getSession();
        String code =((String) session.getAttribute("code")).toLowerCase(Locale.ROOT);
        if (veryifcode(code,session)){
            String username = req.getParameter("userEntity.username");
            System.out.println(username);
            String password = req.getParameter("userEntity.password");
            System.out.println(password);
            UserLogin userLogin = us.loginUser(username, password);
            if (userLogin != null){
                session.setAttribute("loginuser",userLogin);
                result = new Result(true,"登陆成功！",null);
            }else {
            result = new Result(false,"用户名或密码错误！",null);
            }
        }else{
            result = new Result(false,"验证码错误！",null);
        }
        String s = new ObjectMapper().writeValueAsString(result);
        resp.getWriter().write(s);
    }
}
