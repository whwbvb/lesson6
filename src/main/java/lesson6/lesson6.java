package lesson6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

/* 1.С помощью http запроса получить в виде json строки погоду в Санкт-Петербурге на период времени,
 пересекающийся со следующим занятием (например, выборка погода на следующие 5 дней - подойдет)
 2.Подобрать источник самостоятельно.Можно использовать api accuweather, порядок следующий: зарегистрироваться,
 зарегистрировать тестовое приложение для получения api ключа, найдите нужный endpoint и изучите документацию.
 Бесплатный тарифный план предполагает получение погоды не более чем на 5 дней вперед
 (этого достаточно для выполнения д/з).
 */

public class lesson6 {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment("5-295212_1_AL")
                .addQueryParameter("apikey", "6i2ru0buCNBEhRLr7XTCJbfA34gQoGvj")
                .addQueryParameter("language", "ru")
                .addQueryParameter("details", "true")
                .addQueryParameter("metric", "true")
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
