package at.irian.jsfatwork.gui.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Michael Kurz
 */
public class EncodingFilter implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }

}
