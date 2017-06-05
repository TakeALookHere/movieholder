package com.miskevich.movieholder.dao.jdbc.mapper

import com.miskevich.movieholder.entity.Genre
import com.miskevich.movieholder.entity.Movie
import org.testng.annotations.DataProvider

import java.time.LocalDate
import java.time.format.DateTimeFormatter


class DataProviderMapper {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH)

    private static LocalDate convertStringToDate(String dateOfBirth){
        return LocalDate.parse(dateOfBirth, DATE_FORMATTER)
    }

    @DataProvider(name = "provideGenre")
    static Object[][] provideGenre() {

        def expectedGenre = new Genre(id: 1, name: "драма")

        def array = new Object[1][]
        array[0] = [expectedGenre]
        return array
    }

    @DataProvider(name = "provideMovie")
    static Object[][] provideMovie() {

        def expectedMovie = new Movie(id: 1, nameRussian: "Побег из Шоушенка", nameNative: "The Shawshank Redemption",
        releasedDate: convertStringToDate("2016-01-15"), plot: "Успешный банкир Энди Дюфрейн обвинен в убийстве собственной жены и ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом и доброй душой, отказывается мириться с приговором судьбы и начинает разрабатывать невероятно дерзкий план своего освобождения.",
        rating: 8.9, price: 123.45, picturePath: "shawshank173_173.jpg")

        def array = new Object[1][]
        array[0] = [expectedMovie]
        return array
    }
}
