package com.miskevich.movieholder.web.json

import com.miskevich.movieholder.entity.Country
import com.miskevich.movieholder.entity.Genre
import com.miskevich.movieholder.entity.Movie
import com.miskevich.movieholder.entity.Review
import com.miskevich.movieholder.entity.User
import org.testng.annotations.DataProvider

import java.time.LocalDate
import java.time.format.DateTimeFormatter


class JsonDataProvider {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH)

    private static LocalDate convertStringToDate(String dateOfBirth){
        return LocalDate.parse(dateOfBirth, DATE_FORMATTER)
    }

    @DataProvider(name = "provideObjectList")
    static Object[][] provideObjectList() {

        def movies = [
                new Movie(id: 1, nameRussian: "Побег из Шоушенка", nameNative: "The Shawshank Redemption", releasedDate: convertStringToDate("1994-01-01"),
                plot: "Успешный банкир Энди Дюфрейн обвинен в убийстве собственной жены и ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом и доброй душой, отказывается мириться с приговором судьбы и начинает разрабатывать невероятно дерзкий план своего освобождения.",
                rating: 8.9, price: 123.45, picturePath: "shawshank173_173.jpg"),

                new Movie(id: 2, nameRussian: "Зеленая миля", nameNative: "The Green Mile", releasedDate: convertStringToDate("1999-01-01"),
                plot: "Обвиненный в страшном преступлении, Джон Коффи оказывается в блоке смертников тюрьмы «Холодная гора». Вновь прибывший обладал поразительным ростом и был пугающе спокоен, что, впрочем, никак не влияло на отношение к нему начальника блока Пола Эджкомба, привыкшего исполнять приговор.",
                rating: 8.9, price: 134.67, picturePath: "green_mile173_173.jpg"),
        ]



        def expectedJson = "[{\"id\":1,\"nameRussian\":\"Побег из Шоушенка\",\"nameNative\":\"The Shawshank Redemption\",\"releasedDate\":\"1994\",\"countries\":null,\"plot\":\"Успешный банкир Энди Дюфрейн обвинен в убийстве собственной жены и ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом и доброй душой, отказывается мириться с приговором судьбы и начинает разрабатывать невероятно дерзкий план своего освобождения.\",\"rating\":8.9,\"price\":123.45,\"picturePath\":\"shawshank173_173.jpg\",\"genres\":null,\"reviews\":null},{\"id\":2,\"nameRussian\":\"Зеленая миля\",\"nameNative\":\"The Green Mile\",\"releasedDate\":\"1999\",\"countries\":null,\"plot\":\"Обвиненный в страшном преступлении, Джон Коффи оказывается в блоке смертников тюрьмы «Холодная гора». Вновь прибывший обладал поразительным ростом и был пугающе спокоен, что, впрочем, никак не влияло на отношение к нему начальника блока Пола Эджкомба, привыкшего исполнять приговор.\",\"rating\":8.9,\"price\":134.67,\"picturePath\":\"green_mile173_173.jpg\",\"genres\":null,\"reviews\":null}]"

        def array = new Object[1][]
        array[0] = [movies, expectedJson]
        return array
    }

    @DataProvider(name = "provideObject")
    static Object[][] provideObject() {

        def movie = new Movie(
                id: 16,
                nameRussian: "Большой куш",
                nameNative: "Snatch",
                releasedDate: convertStringToDate("2000-01-01"),
                plot: "Четырехпалый Френки должен был переправить краденый алмаз из Англии в США своему боссу Эви. Но вместо этого герой попадает в эпицентр больших неприятностей. Сделав ставку на подпольном боксерском поединке, Френки попадает в круговорот весьма нежелательных событий. Вокруг героя и его груза разворачивается сложная интрига с участием множества колоритных персонажей лондонского дна — русского гангстера, троих незадачливых грабителей, хитрого боксера и угрюмого громилы грозного мафиози. Каждый норовит в одиночку сорвать Большой Куш.",
                rating: 8.5, price: 160.00, picturePath: "bigKush173_173.jpg",
                countries: new ArrayList<Country>(){{
                    add(new Country(
                            id: 3,
                            name: "Великобритания"))
                    add(new Country(
                            id: 1,
                            name: "США"))}},
                genres: new ArrayList<Genre>(){{
                    add(new Genre(
                            id: 2,
                            name: "криминал"))
                    add(new Genre(
                            id: 7,
                            name: "комедия"))}},
                reviews: new ArrayList<Review>(){{
                    add(new Review(
                            id: 14,
                            description: "Удивлен. Никто не отозвался плохо? Неужели было создано произведение искусства, которое нравится всем, и которое совершенно? Нет. Может, я один такой? Фильм не вызывает во мне никаких эмоций. Неплохая сказочка. Замечательная наивная атмосфера. Местами есть забавные шутки. И, как мне показалось, этот фильм — своего рода стёб над другими боевиками. При этом превосходящий многие боевики.",
                            movie: new Movie(id: 16),
                            user: new User(id: 5)))
                    add(new Review(
                            id: 17,
                            description: "Приятного просмотра для всех, кто не видел ещё этого шедевра больше впечатлений для тех, кто пересматривает в надцатый раз. =)",
                            movie: new Movie(id: 16),
                            user: new User(id: 7)))
                    add(new Review(
                            id: 18,
                            description: "Это один из любимых моих фильмов с самого детства. Я видела его столько раз, что знаю практически наизусть. И могу сказать с уверенностью, что посмотрю еще не один раз.",
                            movie: new Movie(id: 16),
                            user: new User(id: 6)))}}
                )



        def expectedJson = "{\"id\":16,\"nameRussian\":\"Большой куш\",\"nameNative\":\"Snatch\",\"releasedDate\":\"2000\",\"countries\":[{\"id\":3,\"name\":\"Великобритания\"},{\"id\":1,\"name\":\"США\"}],\"plot\":\"Четырехпалый Френки должен был переправить краденый алмаз из Англии в США своему боссу Эви. Но вместо этого герой попадает в эпицентр больших неприятностей. Сделав ставку на подпольном боксерском поединке, Френки попадает в круговорот весьма нежелательных событий. Вокруг героя и его груза разворачивается сложная интрига с участием множества колоритных персонажей лондонского дна — русского гангстера, троих незадачливых грабителей, хитрого боксера и угрюмого громилы грозного мафиози. Каждый норовит в одиночку сорвать Большой Куш.\",\"rating\":8.5,\"price\":160.0,\"picturePath\":\"bigKush173_173.jpg\",\"genres\":[{\"id\":2,\"name\":\"криминал\"},{\"id\":7,\"name\":\"комедия\"}],\"reviews\":[{\"id\":14,\"description\":\"Удивлен. Никто не отозвался плохо? Неужели было создано произведение искусства, которое нравится всем, и которое совершенно? Нет. Может, я один такой? Фильм не вызывает во мне никаких эмоций. Неплохая сказочка. Замечательная наивная атмосфера. Местами есть забавные шутки. И, как мне показалось, этот фильм — своего рода стёб над другими боевиками. При этом превосходящий многие боевики.\",\"movie\":{\"id\":16,\"nameRussian\":null,\"nameNative\":null,\"releasedDate\":null,\"countries\":null,\"plot\":null,\"rating\":0.0,\"price\":0.0,\"picturePath\":null,\"genres\":null,\"reviews\":null},\"user\":{\"id\":5,\"nickname\":null,\"email\":null,\"password\":null}},{\"id\":17,\"description\":\"Приятного просмотра для всех, кто не видел ещё этого шедевра больше впечатлений для тех, кто пересматривает в надцатый раз. =)\",\"movie\":{\"id\":16,\"nameRussian\":null,\"nameNative\":null,\"releasedDate\":null,\"countries\":null,\"plot\":null,\"rating\":0.0,\"price\":0.0,\"picturePath\":null,\"genres\":null,\"reviews\":null},\"user\":{\"id\":7,\"nickname\":null,\"email\":null,\"password\":null}},{\"id\":18,\"description\":\"Это один из любимых моих фильмов с самого детства. Я видела его столько раз, что знаю практически наизусть. И могу сказать с уверенностью, что посмотрю еще не один раз.\",\"movie\":{\"id\":16,\"nameRussian\":null,\"nameNative\":null,\"releasedDate\":null,\"countries\":null,\"plot\":null,\"rating\":0.0,\"price\":0.0,\"picturePath\":null,\"genres\":null,\"reviews\":null},\"user\":{\"id\":6,\"nickname\":null,\"email\":null,\"password\":null}}]}"

        def array = new Object[1][]
        array[0] = [movie, expectedJson]
        return array
    }
}
