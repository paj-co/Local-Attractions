package pl.coderslab.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "BusinessLogFilter", urlPatterns = {"/businessapp/*"})
public class BusinessAuthenticationFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpSession httpSession = ((HttpServletRequest) req).getSession();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        if (httpSession.getAttribute("loggedBusiness") == null){
            ((HttpServletResponse) resp).sendRedirect(((HttpServletRequest) req).getContextPath() + "/authentication/login/business/");
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
