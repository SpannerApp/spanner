package spannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spannerapp.CreatingException;
import spannerapp.model.AuthorizationUser;
import spannerapp.service.UserService;

import java.security.cert.CertificateRevokedException;
import java.util.Collection;

/**
 * Created by Siekacz on 23.03.2017.
 */
@RestController
@RequestMapping("/users")
public class AuthorizationUserController {

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
    public int addUser(@RequestBody AuthorizationUser user) throws CreatingException{
        int result = userService.addUser(user);
        if(result == -1)
            throw new CreatingException("user");
        return result;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void validateUser(@RequestBody AuthorizationUser user){
        userService.validateUser(user);
    }
}
