package spannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spannerapp.model.AuthorizationUser;
import spannerapp.service.UserService;

import java.util.Collection;

/**
 * Created by Siekacz on 23.03.2017.
 */
@RestController
@RequestMapping("/users")
public class LoggedUsersController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<AuthorizationUser> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AuthorizationUser getUserByID(@PathVariable ("id") int id) {
        return userService.getUserByID(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUserByID(@PathVariable("id") int id){
        userService.removeStudentByID(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void updateUserByID(@RequestBody AuthorizationUser user){
        userService.updateUser(user);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void insertUserByID(@RequestBody AuthorizationUser user){
        userService.insertUser(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void validateUser(@RequestBody AuthorizationUser user){
        userService.validateUser(user);
    }
}
