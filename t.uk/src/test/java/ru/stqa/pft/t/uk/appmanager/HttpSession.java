package ru.stqa.pft.t.uk.appmanager;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inna on 11.05.2016.
 */
public class HttpSession {
    private CloseableHttpClient httpClient;
    private ApplicationManager app;

    public HttpSession(ApplicationManager app) {
        this.app = app;
        httpClient = HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategy()).build();// создаем новую сессию для работы по протоколу http
    }

    public boolean login(String email, String password) throws IOException {
        HttpPost post = new HttpPost(app.getProperty("web.baseUrl") + "/auth/login"); //передаем параметры
        List<NameValuePair> params = new ArrayList<>();//формирование запроса
        params.add(new BasicNameValuePair("LoginForm[email]", email));
        params.add(new BasicNameValuePair("LoginForm[password]", password));
       // params.add(new BasicNameValuePair("secure_session", "on"));
        params.add(new BasicNameValuePair("return", "index.php"));
        post.setEntity(new UrlEncodedFormEntity(params));//упаковываем все в один запрос
        CloseableHttpResponse response = httpClient.execute(post);//выполнение запроса
        String body = geTextFrom(response);//получаем исходный html код страницы, куда перенаправились
        return body.contains(String.format("<span class=\"hidden-xs\">inna@doubledmarketing.com</span>"));//в коде проверяем есть ли такая строчка
    }

    private String geTextFrom(CloseableHttpResponse response) throws IOException {
        try {
            return EntityUtils.toString(response.getEntity());
        } finally {
            response.close();
        }
    }

    public boolean isLoggedInAs(String username) throws IOException { //ф-я с помощь которой проверяем какой пользователь залогинился в данный момент в систему
        HttpGet get = new HttpGet(app.getProperty("web.baseUrl") + "/index.php");//не передаем параметры, формируем запрос
        CloseableHttpResponse response = httpClient.execute(get);//выполняем запрос и получаем ответ в response
        String body = geTextFrom(response);//получаем текст ответа при помощи вспомагательной функции geTextFrom
        return body.contains(String.format("<span class=\"hidden-xs\">"+username+"</span>")); // проверяем тот ли пользовательзалогинен
    }
}
