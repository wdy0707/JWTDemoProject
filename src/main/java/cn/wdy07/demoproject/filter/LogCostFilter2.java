package cn.wdy07.demoproject.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * @author wdy
 * @create 2020-03-12 15:49
 */
@WebFilter(urlPatterns = "/*",filterName = "logFilter2")
public class LogCostFilter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("LogCostFilter Cost:"+(System.currentTimeMillis()-start));
    }

    @Override
    public void destroy() {

    }
}
