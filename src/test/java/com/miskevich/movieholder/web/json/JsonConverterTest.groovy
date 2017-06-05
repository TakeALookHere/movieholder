package com.miskevich.movieholder.web.json

import org.testng.annotations.Test
import static org.testng.Assert.assertEquals


class JsonConverterTest extends GroovyTestCase {

    @Test(dataProvider = "provideObjectList", dataProviderClass = JsonDataProvider.class)
    void testToJson(movies, expectedJson) {
        def json = JsonConverter.toJson(movies)

        assertEquals(json, expectedJson)
    }
}
