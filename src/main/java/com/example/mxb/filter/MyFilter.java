package com.example.mxb.filter;

import com.example.mxb.entity.Acount;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(filterName = "MyFilter", urlPatterns = {"/index2.html", "/index3.html"})
public class MyFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse rep, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest st = (HttpServletRequest) req;
        HttpServletResponse sp = (HttpServletResponse) rep;
        HttpSession session = st.getSession();
        Acount acount=(Acount) session.getAttribute("acount");
        if (acount != null) {//代表登录过
            chain.doFilter(req, rep);
        } else {
            sp.sendRedirect("/login.html");//重定向 让客户去指定的路径
        }
    }

    public void init(FilterConfig config) {
    }
}
