package org.example.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebFilter(filterName = "logFilter", urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST})
public class LogFilter implements Filter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final List<String> excludedWords = Arrays.asList("newPasswd", "confirmPasswd", "passwd", "password");

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        logger.info("This is logger filter preprocessing");
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String logInfo = logInfo(request);

        filterChain.doFilter(servletRequest, servletResponse);


        logger.info("This is logger filter postprocessing");

        logger.info(logInfo.replace("responseTime", String.valueOf(System.currentTimeMillis() - startTime)));
    }
    private boolean isIgnoredWord(String word, List<String> excludedWords) {
        for (String excludedWord : excludedWords) {
            if (word.toLowerCase().contains(excludedWord)) return true;
        }
        return false;
    }

    private String logInfo(HttpServletRequest req) {
        String formData = null;
        String httpMethod = req.getMethod();

        Date startDateTime = new Date();
        String requestURL = req.getRequestURI();
        String userIP = req.getRemoteHost();
        String sessionID = req.getSession().getId();
        Enumeration<String> parameterNames = req.getParameterNames();
        List<String> parameters = new ArrayList();

        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (isIgnoredWord(paramName, excludedWords)) continue;

            String paramValues = Arrays.asList(req.getParameterValues(paramName)).toString();
            parameters.add(paramName + "=" + paramValues);
        }

        if (!parameters.isEmpty()) {
            formData = parameters.toString().replaceAll("^.|.$", "");
        }

        return  new StringBuilder("###@@@$$$  ")
                .append("| ")
                .append(formatter.format(startDateTime)).append(" | ")
                .append(userIP).append(" | ")
                .append(httpMethod).append(" | ")
                .append(requestURL).append(" | ")
                .append(sessionID).append(" | ")
                .append("responseTime ms").append(" | ")
                .append(formData).toString();
    }
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
