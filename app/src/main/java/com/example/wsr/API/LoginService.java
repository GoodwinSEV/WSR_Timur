package com.example.wsr.API;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {
    @POST("auth/")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);
}