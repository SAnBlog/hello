//package cn.sanii.hello.filter;
//
//
//import cn.sanii.hello.bean.User;
//import cn.sanii.hello.util.CookieUtils;
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
//
///**
// * @Auther: shouliang.wang
// * @Date: 2018/5/7 11:58
// * @Description: 认证token
// */
//@WebFilter(filterName = "loginFilter", urlPatterns = "/*")
//public class LoginFilter implements Filter {
//
//    private static final Logger logger =LoggerFactory.getLogger(LoginFilter.class);
//
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        //获取Cookie中的token
//        String token = CookieUtils.getCookieValue((HttpServletRequest) servletRequest, "token", true);
//        //判断token是否存在
//        if (!StringUtils.isBlank(token)) {
//            //获取token中的用户信息
//            User user = JWT.unsign(token, User.class);
//            //通过UUID KEY查redis是否存在token（是否过期）
//            String tokenInfo = stringRedisTemplate.opsForValue().get(user.getUuid());
//            //如果tokenInfo没有过期
//            if (!StringUtils.isBlank(tokenInfo)) {
//                //如果token一致
//                if (tokenInfo.equals(token)) {
//                    //放行
//                    filterChain.doFilter(servletRequest, servletResponse);
//                    return;
//                }
//            }
//        }
//        //如果token不存在，但是请求url是登录，放行去登录
//        if (((HttpServletRequest) servletRequest).getServletPath().equals("/user/login")) {
//            //放行
//            filterChain.doFilter(servletRequest, servletResponse);
//            return;
//        }
//        //如果token不存在 1.身份过期，重新登录2.未登录
//        RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/user/error");
//        dispatcher.forward(servletRequest, servletResponse);
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
