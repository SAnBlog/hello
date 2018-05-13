package cn.sanii.hello.Controller;

import cn.sanii.hello.bean.BaseResponse;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description 异常处理
 * @Date 2018-04-09
 * @Time 17:09
 */
@RestControllerAdvice
public class ExceptionController {

    private final BaseResponse<String> resultMap = new BaseResponse<>();


    // 捕捉shiro的异常
    @ExceptionHandler(ShiroException.class)
    public BaseResponse<String> handle401() {
        return resultMap.setError("您没有权限访问！");
    }

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    public BaseResponse<String> globalException(HttpServletRequest request, Throwable ex) {

        return resultMap.setError(ex.getMessage());
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
