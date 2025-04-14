package com.itgirls.restapp.controller;

import com.itgirls.restapp.entity.User;
import com.itgirls.restapp.service.UserService;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// https://mysite.com/users
// localhost:8080/RestApp/users
@WebServlet("/users")
public class UserServlet extends HttpServlet {

//    private final UserService;
//    public UserServlet() {
//this.userService = new UserService();
//
//    }

    //create
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (InputStream is = request.getInputStream();
             JsonReader reader = Json.createReader(is)
        ) {
            JsonObject jsonObject = reader.readObject();
            String name = jsonObject.getString("name");
            Integer age = jsonObject.getInt("age");

            User user = new User(name, age);
            user.setAge(age + 1);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            JsonObject jsonResponseObject = Json.createObjectBuilder()
                    .add("name", user.getName())
                    .add("age", user.getAge())
                    .build();

            try (OutputStream os = response.getOutputStream();
                 JsonWriter writer = Json.createWriter(os)
            ) {
                writer.writeObject(jsonResponseObject);
            }
        }
    }

    //read
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User("Fred", 25);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        JsonObject jsonObject = Json.createObjectBuilder()
                .add("name", user.getName())
                .add("age", user.getAge())
                .build();

        try (OutputStream os = response.getOutputStream();
             JsonWriter writer = Json.createWriter(os)
        ) {
            writer.writeObject(jsonObject);
        }
    }
}
