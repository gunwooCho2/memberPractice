package com.busanit501.firstpractice.Utill;

import javax.servlet.http.Cookie;
import java.util.Arrays;

public enum CookieUtil {
    INSTANCE;

    public Cookie getCookie(Cookie[] cookies, String name) {
        if (cookies == null) return null;
        return Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public Cookie removeCookie(Cookie[] cookies, String name) {
        if (cookies == null) return null;
        Cookie cookie = getCookie(cookies, name);
        if (cookie == null) return null;
        cookie.setValue(null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        return cookie;
    }
}
