package com.alkemy.ong.model.response;

import com.alkemy.ong.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserRegisterResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public static UserRegisterResponse mapToResponse(User user) {
        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
        userRegisterResponse.setId(user.getId());
        userRegisterResponse.setFirstName(user.getFirstName());
        userRegisterResponse.setLastName(user.getLastName());
        userRegisterResponse.setEmail(user.getEmail());

        return userRegisterResponse;
    }

}
