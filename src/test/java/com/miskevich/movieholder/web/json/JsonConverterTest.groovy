package com.miskevich.movieholder.web.json

import org.testng.annotations.Test
import static org.testng.Assert.assertEquals


class JsonConverterTest extends GroovyTestCase {

    @Test(dataProvider = "provideObjectList", dataProviderClass = JsonDataProvider.class)
    void testObjListToJson(movies, expectedJson) {
        def actualJson = JsonConverter.toJson(movies)

        assertEquals(actualJson, expectedJson)
    }

    @Test(dataProvider = "provideObject", dataProviderClass = JsonDataProvider.class)
    void testObjToJson(movie, expectedJson) {
        def actualJson = JsonConverter.toJson(movie)

        assertEquals(actualJson, expectedJson)
    }
}
