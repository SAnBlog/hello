package cn.sanii.hello.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Auther: shouliang.wang
 * @Date: 2018/5/3 18:15
 * @Description: AOP 记录Controller方法日志
 */
@Aspect
@Component
public class LogAspect {

    //使用org.slf4j.Logger,这是Spring实现日志的方法
    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * @param
     * @return 公用切入点
     * @author shouliang.wang
     * @date 2018/5/4 14:18
     */
    @Pointcut("execution(public * cn.sanii.hello.Controller.UserController.*(..))")
    public void commPointCut() {
    }

    /**
     * @param
     * @return 方法开始日志
     * @author shouliang.wang
     * @date 2018/5/3 19:04
     */
    @Before("commPointCut()")
    public void start(JoinPoint point) {
        this.log(point);
    }

    /**
     * @param
     * @return 方法执行结束日志
     * @author shouliang.wang
     * @date 2018/5/3 19:04
     */
    @After("commPointCut()")
    public void end(JoinPoint point) {
        this.log(point);
        //移除ip信息
        MDC.remove("ip");
    }

    /**
     * @author shouliang.wang
     * @date 2018/5/4 14:37
     * @param object 每次请求返回的数据
     * @return
     */
    @AfterReturning(returning = "object", pointcut = "commPointCut()")
    public void doAfterReturn(Object object) {
        logger.info("reponse:{}", object);
    }

    /**
     * @param point 类信息
     * @return 日志
     * @author shouliang.wang
     * @date 2018/5/3 19:03
     */
    void log(JoinPoint point) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //ip
        String ip = request.getRemoteAddr();
        //method
        String method = request.getMethod();
        String uri = request.getRequestURI();
        //获取类名+类方法
        String name = point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName();
        Object[] args = point.getArgs();
        //IP 注入 log日志
        MDC.put("ip", ip);

        logger.info("请求类型:{} 类信息:{} 参数:{} url:{} ip:{}", method, name, args, uri, ip);
    }
}
