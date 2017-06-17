package com.miskevich.movieholder.dao.jdbc

import com.miskevich.movieholder.entity.Movie
import com.miskevich.movieholder.entity.Review
import com.miskevich.movieholder.entity.User
import org.testng.annotations.DataProvider


class DataProviderJdbc {

    @DataProvider(name = "provideAddReview")
    static Object[][] provideAddReview(){
        def reviewForAdd = new Review(
                description: "Тестовый дескрипшен для ревью",
                movie: new Movie(id: 1),
                user: new User(id: 3))

        def array = new Object[1][]
        array[0] = reviewForAdd
        return array
    }
}
