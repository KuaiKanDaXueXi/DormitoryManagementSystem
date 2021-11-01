package com.xian.web.servlet;

import com.xian.utils.DownloadUtils;
import com.xian.utils.FileUtils;
import com.xian.utils.ImportExportUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author Xian
 */
@WebServlet("/download")
public class DownloadServlet extends BaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = (String) req.getAttribute("filename");
        //使用字节输入流加载文件进内存
        //找到文件的服务器路径
        ServletContext context = req.getServletContext();
        String type = context.getMimeType(filename);
        resp.setContentType(type);
        //2.设置响应头打开方式：
        //解决中文文件问题
        //获取user-agent请求头
        String agent = req.getHeader("user-agent");
        //使用工具类方法编码文件名即可
        filename = DownloadUtils.getFileName(agent, filename);
        resp.setHeader("content-disposition","attachment;filename="+filename);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    /*
        resp.setContentType("application/vnd.ms-excel");
        resp.setCharacterEncoding("utf-8");
        String fileName = t.getClass().getSimpleName()+" Information.xlsx";
        resp.setHeader("Content-disposition", "attachment;filename=" + fileName);
        ImportExportUtil.export(resp.getOutputStream(), t, list);
    */
}
