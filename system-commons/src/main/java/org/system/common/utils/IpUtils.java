package org.system.common.utils;

/*
 *  时间： 2008-7-30 17:17:26<br>
 *  北京完美时空网络技术有限公司<br>
 */

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;


/**
 * Created by IntelliJ IDEA.<br>
 * author: liliangyang<br>
 * date: 2008-7-30<br>
 * time: 17:17:26<br>
 * vision: 1.0<br>
 * description:完美系统部web开发组<br>
 * project:活动模块开发<br>
 * Ip操作相关 <br>
 */
public class IpUtils {
    static Logger logger = LoggerFactory.getLogger(IpUtils.class);

    /**
     * 取用户的真实ip地址
     * 可以避免因为网关造成
     *
     * @param request
     * @return ip
     */
    public static String getRealIp(HttpServletRequest request) {

        return getLastIpAddressExcludeWhite(request,null);

    }

    private static String parseIpFromRequest(HttpServletRequest request)
    {
        String ip = request.getHeader("X-Forwarded-For");
        if ((StringUtils.isBlank(ip)) || (StringUtils.equalsIgnoreCase(ip, "unknown"))) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if ((StringUtils.isBlank(ip)) || (StringUtils.equalsIgnoreCase(ip, "unknown"))) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if ((StringUtils.isBlank(ip)) || (StringUtils.equalsIgnoreCase(ip, "unknown"))) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if ((StringUtils.isBlank(ip)) || (StringUtils.equalsIgnoreCase(ip, "unknown"))) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if ((StringUtils.isBlank(ip)) || (StringUtils.equalsIgnoreCase(ip, "unknown"))) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    public static String getLastIpAddressExcludeWhite(HttpServletRequest request, Set<String> whites)
    {
        String ip = parseIpFromRequest(request);
        if ((StringUtils.isNotBlank(ip)) && (StringUtils.indexOf(ip, ",") > 0)) {
            String[] ipArray = StringUtils.split(ip, ",");
            if (ipArray != null) {
                int len = ipArray.length;
                for (int i = len - 1; i >= 0; i--) {
                    ip = ipArray[i].trim();
                    if (whites == null)
                        break;
                    if (!whites.contains(ip)) {
                        break;
                    }
                }
            }
        }
        if ((StringUtils.isBlank(ip)) || (ip.equalsIgnoreCase("unknown"))) {
            ip = "127.127.127.127";
            logger.warn(new StringBuilder().append("ipaddress is blank, set default value : ").append(request.getRequestURI()).toString());
        }
        return ip;
    }
}

