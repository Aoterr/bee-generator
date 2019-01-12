package com.bee.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * created by guos on 2018/11/10
 */
public class CookieUtil {
    public static Cookie getCookie(HttpServletRequest httpServletRequest, String cookieKey) {
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies == null) {
            return null;
        }

        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals(cookieKey)) {
                return cookie;
            }
        }

        return null;
    }

    public static Cookie generateCookie(String cookieName, String value, String path, int time) {
        Cookie cookie = new Cookie(cookieName, value);
        cookie.setPath(path);
        cookie.setMaxAge(time);
        return cookie;
    }
}
