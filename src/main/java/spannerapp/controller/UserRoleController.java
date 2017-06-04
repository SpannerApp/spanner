package spannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spannerapp.model.UserRole;
import spannerapp.service.IUserRoleService;

import java.util.Collection;

/**
 * Created by Siekacz on 04.06.2017.
 */
@RestController
@RequestMapping("/roles")
public class UserRoleController {

    @Autowired
    private IUserRoleService userRoleService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<UserRole> getAllUserRoles(){ return userRoleService.getAllUserRoles(); }

}
