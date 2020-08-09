package it.project.provider;

import me.postaddict.instagram.scraper.Instagram;
import me.postaddict.instagram.scraper.cookie.CookieHashSet;
import me.postaddict.instagram.scraper.cookie.DefaultCookieJar;
import me.postaddict.instagram.scraper.interceptor.ErrorInterceptor;
import me.postaddict.instagram.scraper.model.Account;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import java.io.IOException;

public class ServiceProvider {
    public ServiceProvider() {
        System.out.println("RUNNING");
//        dBConnection();
        getInstaData();

    }

    public void getInstaData(){

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(loggingInterceptor)
                .addInterceptor(new ErrorInterceptor())
                .cookieJar(new DefaultCookieJar(new CookieHashSet()))
                .build();

        System.out.println("setup http client");

        Instagram instagram = new Instagram(httpClient);
        Account account = null;
        try {
            System.out.println("Connect to account");
            account = instagram.getAccountByUsername("dulanaka_navojith1");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("--------------");
        System.out.println(account.getMedia().getCount());
//        System.out.println(account.getFullName());
//        System.out.println(account.getFollows());

//        System.out.println(account.getFollowedBy());
//        System.out.println(account.getMedia().getPageInfo());
//        System.out.println(account.getMedia().hashCode());
//        System.out.println(account.getConnectedFbPage());
//        System.out.println(account.getCountryBlock());
//        System.out.println(account.getMedia());
        System.out.println("--------------");
        System.out.println(account.getMedia());
    }
}
