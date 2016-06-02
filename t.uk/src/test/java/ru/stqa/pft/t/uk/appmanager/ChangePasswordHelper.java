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
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChangePasswordHelper {
    private CloseableHttpClient httpClient;
    private ApplicationManager app;

    public ChangePasswordHelper(ApplicationManager app) {
        this.app = app;
        httpClient = HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategy()).build();
    }

    private String geTextFrom(CloseableHttpResponse response) throws IOException {
        try {
            return EntityUtils.toString(response.getEntity());
        } finally {
            response.close();
        }
    }

    public boolean changePass(String id, String password_old, String password, String password2) throws IOException {
        HttpPost post = new HttpPost(app.getProperty("web.baseUrl") + "/account/profile?current-tab[0]=%23password"); //передаем параметры
        List<NameValuePair> params = new ArrayList<>();//формирование запроса
        params.add(new BasicNameValuePair("PasswordForm[id]", id));
        params.add(new BasicNameValuePair("PasswordForm[oldPassword]", password_old));
        params.add(new BasicNameValuePair("PasswordForm[password]", password));
        params.add(new BasicNameValuePair("PasswordForm[password2]", password2));
        post.setEntity(new UrlEncodedFormEntity(params));//упаковываем все в один запрос
        CloseableHttpResponse response = httpClient.execute(post);//выполнение запроса
        String body = geTextFrom(response);//получаем исходный html код страницы, куда перенаправились
        return body.contains(String.format("<span class=\"hidden-xs\">inna@doubledmarketing.com</span>"));//в коде проверяем есть ли такая строчка
    }
}


