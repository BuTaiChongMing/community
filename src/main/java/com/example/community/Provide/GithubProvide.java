package com.example.community.Provide;

import com.alibaba.fastjson.JSON;
import com.example.community.dto.AccessTokenDTO;
import com.example.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvide {
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(JSON.toJSONString(accessTokenDTO),mediaType);
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token?client_id="+accessTokenDTO.getClient_id()+"&client_secret="+accessTokenDTO.getClient_secret()+"&code="+accessTokenDTO.getCode()+"&redirect_uri="+accessTokenDTO.getRedirect_uri()+"")
                .post(body)
            .build();
        try (Response response = client.newCall(request).execute()) {
        String string = response.body().string();
        String token =string.split("&")[0].split("=")[1];
        return  token;
    } catch (IOException e) {
    }
        return null;
}
    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization","token "+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string,GithubUser.class);
            return githubUser;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
