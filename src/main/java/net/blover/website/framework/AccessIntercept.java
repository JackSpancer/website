package net.blover.website.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class AccessIntercept extends HandlerInterceptorAdapter {

    private static Logger log = LoggerFactory.getLogger(AccessIntercept.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("access[" + request.getRequestURI() + "]");
        log.info("the param[" + getValue(request) + "]");
        return super.preHandle(request, response, handler);
    }

    public static String getValue(HttpServletRequest request){
        String value = "";
        Enumeration enu = request.getParameterNames();
        while(enu.hasMoreElements()){
            String paraName = (String)enu.nextElement();
            if (!"_dc".equals(paraName) && !"node".equals(paraName)){//_dc的参数不要
                String [] arr = request.getParameterValues(paraName);
                if (arr != null && arr.length > 1){
                    value += paraName+"="+arr+";";
                }else{
                    value += paraName+"="+request.getParameter(paraName)+";";
                }
            }
        }
        return value;
    }
}
