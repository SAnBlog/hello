package cn.sanii.hello.Controller;

import cn.sanii.hello.mq.Sender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RabbitmqController {
    private static final Logger logger=LoggerFactory.getLogger(RabbitmqController.class);
    @Autowired
    private Sender sender;

    /**
     * @author shouliang.wang
     * @date 2018/5/10 17:30
     * @param msg 发现的消息体 count测试循环次数
     * @return
     * @Description:
     * 发送消息
     */
    @GetMapping("/send")
    public String send(HttpServletRequest request, String msg, int count) {
        long currentTimeMillis = System.currentTimeMillis();
        while (count >= 0) {
            sender.send(msg+count);
            count -= 1;
        }
        logger.info("总耗时:{}",(System.currentTimeMillis()-currentTimeMillis));
        return "Send OK 总耗时:"+(System.currentTimeMillis()-currentTimeMillis);
    }
}
