package com.hfut.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoInterceptor implements HandlerInterceptor {
    /**/
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle");
        return true;
    }
 /*日志记录
 * 敏感词语过滤*/
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("往"+modelAndView.getViewName()+"跳转");
        System.out.println("model的值"+modelAndView.getModel().get("model"));
        String word=modelAndView.getModel().get("model").toString();
        String newWord=word.replace("祖国","**");  //用于敏感词语过滤
        modelAndView.getModel().put("model",newWord);
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
        System.out.println("收集异常信息："+e.getMessage());
    }
}
