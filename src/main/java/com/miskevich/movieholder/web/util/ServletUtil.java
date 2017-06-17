package com.miskevich.movieholder.web.util;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

public class ServletUtil {

    public static String getFirstValueOfRequestParam(HttpServletRequest request, String paramName) {
        String[] param = request.getParameterValues(paramName);
        return param[0];
    }

    public static String generateJson(HttpServletRequest request) {
        String line;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }
}
