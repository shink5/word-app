package com.example.logintest.data;

import com.example.logintest.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            if (username.equals("me") && password.equals("123456")){
                LoggedInUser TrueUser =
                        new LoggedInUser(
                                username,username);
                return new Result.Success<>(TrueUser);
            }else {
                LoggedInUser fakeUser =
                        new LoggedInUser(
                                username,"Fault");
                return new Result.Fault<>(fakeUser);
            }
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
