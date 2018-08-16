package com.zy.ssm.interceptor;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	Logger logger = Logger.getLogger(LoginInterceptor.class);
	 private String getParamString(Map<String, String[]> map) {
	        StringBuilder sb = new StringBuilder();
	        for(Entry<String,String[]> e:map.entrySet()){
	            sb.append(e.getKey()).append("=");
	            String[] value = e.getValue();
	            if(value != null && value.length == 1){
	                sb.append(value[0]).append("\t");
	            }else{
	                sb.append(Arrays.toString(value)).append("\t");
	            }
	        }
	        return sb.toString();
	    }

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			long startTime = System.currentTimeMillis();
			System.out.println("xxxx==============");
		  if (handler instanceof HandlerMethod) {
	            StringBuilder sb = new StringBuilder(1000);
	            sb.append(new SimpleDateFormat("hh:mm:ss.SSS").format(startTime)).append("-------------------------------------\n");
	            HandlerMethod h = (HandlerMethod) handler;
	            sb.append("Controller: ").append(h.getBean().getClass().getName()).append("\n");
	            sb.append("Method    : ").append(h.getMethod().getName()).append("\n");
	            sb.append("Params    : ").append(getParamString(request.getParameterMap())).append("\n");
	            sb.append("URI       : ").append(request.getRequestURI()).append("\n");
	            System.out.println(sb.toString());
	            logger.info(sb.toString());
	        }
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
