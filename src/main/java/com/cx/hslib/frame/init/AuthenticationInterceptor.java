package com.cx.hslib.frame.init;



import com.alibaba.fastjson.JSON;
import com.cx.hslib.frame.annotation.LoginRequired;
import com.cx.hslib.frame.constants.CurrentUserConstants;
import com.cx.hslib.frame.util.TokenUtils;
import com.cx.hslib.models.sys.SysUser;
import com.cx.tool.bean.MessageBean;
import com.cx.tool.utils.MailUtil;
import io.jsonwebtoken.Claims;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @description:Token验证过滤器,判断是否已登录
 * @author:@luomouren.
 * @Date:2017-12-10 22:40
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    protected static final Logger logger = Logger.getLogger(AuthenticationInterceptor.class);

    public final static String ACCESS_TOKEN = "accessToken";
//    @Autowired
//    private SysUserService userService;

    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 判断接口是否需要登录
        LoginRequired methodAnnotation = method.getAnnotation(LoginRequired.class);
        // 有 @LoginRequired 注解，需要认证
        if (methodAnnotation != null) {
            // 判断是否存在令牌信息，如果存在，则允许登录
            //String accessToken = request.getParameter(ACCESS_TOKEN);

            //if (null == accessToken) {
                //PrintWriter printWriter = response.getWriter();
                //printWriter.write("{code:0,message:\"session is invalid,please login again!\"}");
               // throw new RuntimeException("无token，请重新登录");
                //logger.debug("无token，请重新登录");
                //PrintWriter printWriter = response.getWriter();
                //printWriter.write("{code:0,message:\"session is invalid,please login again!\"}");
                //return false;
                //return false;
            //}
            //Claims claims = TokenUtils.parseJWT(accessToken);
            //String userName = claims.getId();
//            SysUser user = userService.findByUserName(userName);
            //SysUser user =null;

//            SysUser user = (SysUser) session.getAttribute(WebMvcConfigurer.SESSION_KEY);
            Map<String,Object> user = (Map<String, Object>) session.getAttribute(WebMvcConfigurer.SESSION_KEY);
            if (user == null) {

                throw new RuntimeException("用户不存在，请重新登录");
                //logger.debug("用户不存在，请重新登录");
                //PrintWriter printWriter = response.getWriter();
                //printWriter.write("{code:0,message:\"session is invalid,please login again!\"}");
                //return false;
            }
            // 当前登录用户@CurrentUser
            request.setAttribute(CurrentUserConstants.CURRENT_USER, user);
            return true;


        }else{
            return true;
        }
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    private boolean reLogin(HttpServletResponse response) throws IOException {
        PrintWriter out;
        try{
            MessageBean res = new MessageBean<String>(1,"无token信息");
            out = response.getWriter();
            out.append(JSON.toJSONString(res));
            return false;
        } catch (Exception e){
            e.printStackTrace();
            response.sendError(500);
            return false;
        }
    }

}
