package com.miskevich.movieholder.dao.jdbc.mapper

import com.miskevich.movieholder.entity.Country
import com.miskevich.movieholder.entity.Genre
import com.miskevich.movieholder.entity.Movie
import com.miskevich.movieholder.entity.Review
import com.miskevich.movieholder.entity.User
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
        array[0] = expectedGenre
        return array
    }

    @DataProvider(name = "provideMovie")
    static Object[][] provideMovie() {

        def expectedMovie = new Movie(id: 1, nameRussian: "Побег из Шоушенка", nameNative: "The Shawshank Redemption",
        releasedDate: convertStringToDate("2016-01-15"), plot: "Успешный банкир Энди Дюфрейн обвинен в убийстве собственной жены и ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом и доброй душой, отказывается мириться с приговором судьбы и начинает разрабатывать невероятно дерзкий план своего освобождения.",
        rating: 8.9, price: 123.45, picturePath: "shawshank173_173.jpg")

        def array = new Object[1][]
        array[0] = expectedMovie
        return array
    }

    @DataProvider(name = "provideCountry")
    static Object[][] provideCountry(){
        def expectedCountry = new Country(id: 1, name: "США")

        def array = new Object[1][]
        array[0] = expectedCountry
        return array
    }

    @DataProvider(name = "provideReview")
    static Object[][] provideReview(){
        def expectedReview = new Review(id: 1, description: "Гениальное кино! Смотришь и думаешь «Так не бывает!», но позже понимаешь, что только так и должно быть. Начинаешь заново осмысливать значение фразы, которую постоянно используешь в своей жизни, «Надежда умирает последней». Ведь если ты не надеешься, то все в твоей жизни гаснет, не остается смысла. Фильм наполнен бесконечным числом правильных афоризмов. Я уверена, что буду пересматривать его сотни раз.",
        movie: new Movie(id: 1), user: new User(id: 3))

        def array = new Object[1][]
        array[0] = expectedReview
        return array
    }

    @DataProvider(name = "provideUser")
    static Object[][] provideUser(){
        def expectedUser = new User(id: 2, nickname: "Рональд Рейнольдс", email: "ronald.reynolds66@example.com")

        def array = new Object[1][]
        array[0] = expectedUser
        return array
    }
}
