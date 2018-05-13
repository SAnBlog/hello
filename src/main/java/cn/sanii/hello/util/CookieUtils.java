package cn.sanii.hello.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Cookie 工具类
 *
 * @author
 * @date
 */
public final class CookieUtils {
    protected static final Logger LOGGER = LoggerFactory
            .getLogger(CookieUtils.class);

    /**
     * 获取cookie的值
     *
     * @author
     * @date
     * @param req
     * @param cookieName
     * @param isDecoder
     * 是：utf-8编码 否：不编码使用默认的
     * @return
     */
    public static String getCookieValue(HttpServletRequest req, String cookieName, Boolean isDecoder) {
        Cookie[] cookieList = req.getCookies();
        if (cookieList == null || cookieName == null) {
            return null;
        }
        String retValueString = null;
        try {
            for (int i = 0; i < cookieList.length; i++) {
                if (cookieList[i].getName().equals(cookieName)) {
                    if (isDecoder) {
                        retValueString = URLDecoder.decode(
                                cookieList[i].getValue(), "utf-8");
                    } else {
                        retValueString = cookieList[i].getValue();
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("Cookie Decode Error : ", e);
        }
        return retValueString;

    }

    /**
     * 设置cookie
     *
     * @author
     * @date
     * @param req
     * @param res
     * @param cookieName
     * @param cookieValue
     * @param cookieMaxAge
     * 设置cookie最大生存时间 单位秒
     * @param isDecoder
     * 是：utf-8编码 否：不编码使用默认的
     */
    public static void setCookie(HttpServletRequest req,
                                 HttpServletResponse res, String cookieName, String cookieValue,
                                 int cookieMaxAge, Boolean isDecoder) {
        if (cookieValue == null) {
            LOGGER.info(cookieName + " 为 null");
            return;
        }
        try {
            if (isDecoder) {
                cookieValue = URLEncoder.encode(cookieValue, "utf-8");
            }
            Cookie cookie = new Cookie(cookieName, cookieValue);
            if (cookieMaxAge > 0) {
                cookie.setMaxAge(cookieMaxAge);
            }
            if (req != null) {
                cookie.setDomain(getDomainName(req)); //设置cookie域名
            }
            cookie.setPath("/");
            res.addCookie(cookie);
        } catch (Exception e) {
            LOGGER.error("Cookie Decode Error : ", e);
        }

    }
    /**
     * 删除cookie
     * @author
     * @date
     * @param req
     * @param res
     * @param cookieName
     */
    public static void deleteCookie(HttpServletRequest req,HttpServletResponse res,String cookieName){
        setCookie(req, res, cookieName, "", 0, false);
    }

    /**
     * 获取cookie作用域
     * @author gaobing
     * @date 2016年11月23日 上午11:13:37
     * @param req
     * @return
     */
    private static final String getDomainName(HttpServletRequest req) {
        String domainName = "";
        String serverName = req.getRequestURL().toString();

//String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort();
        if (StringUtils.isNotBlank(serverName)) {
            serverName = serverName.toLowerCase().substring(7);
            final int end = serverName.indexOf("/");
            serverName = serverName.substring(0, end);
            final String[] domains = serverName.split("\\.");// \\表示转义
            int len = domains.length;
            if (len > 3) {
// www.xxx.com.cn
                domainName = "." + domains[len - 3] + "." + domains[len - 2]
                        + "." + domains[len - 1];
            } else if (len <= 3 && len > 1) {
// xxx.com or xxx.cn
                domainName = "." + domains[len - 2] + "." + domains[len - 1];
            } else {
                domainName = serverName;
            }
        }

        if (domainName != "" && domainName.indexOf(":") > 0) {
            String[] ary = domainName.split("\\:");
            domainName = ary[0];
        }
        return domainName;
    }

}