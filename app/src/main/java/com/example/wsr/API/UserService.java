package com.example.wsr.API;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("auth/register/")
    Call<UserResponse> saveUsers(@Body UserRequest userRequest);
}
