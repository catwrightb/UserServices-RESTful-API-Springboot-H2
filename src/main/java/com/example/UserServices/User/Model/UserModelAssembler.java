package com.example.UserServices.User.Model;

import com.example.UserServices.User.Controller.UserController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {


    @Override
    public EntityModel<User> toModel(User user) {
        return EntityModel.of(user,
                linkTo(methodOn(UserController.class).getUser(user.getEmail())).withSelfRel(),
                linkTo(methodOn(UserController.class).getUsers()).withRel("users"));
    }
}
