package com.xian.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class A_filter implements Filter {
    private String encode = null;
    @Override
    public void init(FilterConfig config) throws ServletException{
        //获取在web.xml文件中配置了的编码格式的信息
        this.encode = config.getInitParameter("encode");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if(this.encode != null && !"".equals(this.encode)){
            req.setCharacterEncoding(this.encode);
            resp.setCharacterEncoding(this.encode);
        }else{
            req.setCharacterEncoding("utf-8");
            resp.setCharacterEncoding("utf-8");
        }

        chain.doFilter(req,resp);
        resp.setContentType("text/html");
    }
}
