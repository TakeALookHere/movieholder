package com.miskevich.movieholder.dao.jdbc

import com.miskevich.movieholder.entity.Movie
import org.testng.annotations.DataProvider

import java.time.LocalDate
import java.time.format.DateTimeFormatter


class JsonDataProvider {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH)

    private static LocalDate convertStringToDate(String dateOfBirth){
        return LocalDate.parse(dateOfBirth, DATE_FORMATTER)
    }

    @DataProvider(name = "provideObjectList")
    static Object[][] provideResponseNotNull() {

        def movies = [
                new Movie(id: 1, nameRussian: "Побег из Шоушенка", nameNative: "The Shawshank Redemption", releasedDate: convertStringToDate("1994-01-01"),
                plot: "Успешный банкир Энди Дюфрейн обвинен в убийстве собственной жены и ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом и доброй душой, отказывается мириться с приговором судьбы и начинает разрабатывать невероятно дерзкий план своего освобождения.",
                rating: 8.9, price: 123.45, picturePath: "shawshank173_173.jpg"),

                new Movie(id: 2, nameRussian: "Зеленая миля", nameNative: "The Green Mile", releasedDate: convertStringToDate("1999-01-01"),
                plot: "Обвиненный в страшном преступлении, Джон Коффи оказывается в блоке смертников тюрьмы «Холодная гора». Вновь прибывший обладал поразительным ростом и был пугающе спокоен, что, впрочем, никак не влияло на отношение к нему начальника блока Пола Эджкомба, привыкшего исполнять приговор.",
                rating: 8.9, price: 134.67, picturePath: "green_mile173_173.jpg"),
        ]



        def expectedJson = "[{\"id\":1,\"nameRussian\":\"Побег из Шоушенка\",\"nameNative\":\"The Shawshank Redemption\",\"releasedDate\":{\"year\":1994,\"month\":\"JANUARY\",\"dayOfMonth\":1,\"dayOfWeek\":\"SATURDAY\",\"era\":\"CE\",\"dayOfYear\":1,\"leapYear\":false,\"monthValue\":1,\"chronology\":{\"id\":\"ISO\",\"calendarType\":\"iso8601\"}},\"countries\":null,\"plot\":\"Успешный банкир Энди Дюфрейн обвинен в убийстве собственной жены и ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом и доброй душой, отказывается мириться с приговором судьбы и начинает разрабатывать невероятно дерзкий план своего освобождения.\",\"rating\":8.9,\"price\":123.45,\"picturePath\":\"shawshank173_173.jpg\",\"genres\":null,\"reviews\":null},{\"id\":2,\"nameRussian\":\"Зеленая миля\",\"nameNative\":\"The Green Mile\",\"releasedDate\":{\"year\":1999,\"month\":\"JANUARY\",\"dayOfMonth\":1,\"dayOfWeek\":\"FRIDAY\",\"era\":\"CE\",\"dayOfYear\":1,\"leapYear\":false,\"monthValue\":1,\"chronology\":{\"id\":\"ISO\",\"calendarType\":\"iso8601\"}},\"countries\":null,\"plot\":\"Обвиненный в страшном преступлении, Джон Коффи оказывается в блоке смертников тюрьмы «Холодная гора». Вновь прибывший обладал поразительным ростом и был пугающе спокоен, что, впрочем, никак не влияло на отношение к нему начальника блока Пола Эджкомба, привыкшего исполнять приговор.\",\"rating\":8.9,\"price\":134.67,\"picturePath\":\"green_mile173_173.jpg\",\"genres\":null,\"reviews\":null}]"

        def array = new Object[1][]
        array[0] = [movies, expectedJson]
        return array
    }
}
