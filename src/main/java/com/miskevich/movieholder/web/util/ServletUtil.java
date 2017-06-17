package com.miskevich.movieholder.web.util;

import javax.servlet.http.HttpServletRequest;

public class ServletUtil {

    public static String getFirstValueOfRequestParam(HttpServletRequest request, String paramName) {
        String[] param = request.getParameterValues(paramName);
        return param[0];
    }
}
