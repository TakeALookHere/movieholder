package com.miskevich.movieholder.web.util

import org.testng.annotations.Test

import javax.servlet.http.HttpServletRequest
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.when


class ServletUtilTest extends GroovyTestCase {

    @Test
    void testGetRequestParam() {
        String[] param = new String[1]
        param[0] = '3'
        HttpServletRequest request = mock(HttpServletRequest.class)
        when(request.getParameterValues('genre')).thenReturn(param)
        def actualParam = ServletUtil.getFirstValueOfRequestParam(request, 'genre')
        assertEquals(actualParam, '3')
    }
}
