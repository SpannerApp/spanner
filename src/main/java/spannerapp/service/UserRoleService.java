package spannerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spannerapp.dao.IUserRoleDAO;
import spannerapp.dao.JdbcUserRoleDAO;
import spannerapp.model.UserRole;

import java.util.List;

/**
 * Created by Siekacz on 04.06.2017.
 */
@Service
public class UserRoleService implements IUserRoleService {

    @Autowired
    private IUserRoleDAO userRoleDAO;

    @Override
    public List<UserRole> getAllUserRoles() {
        return userRoleDAO.getAllUserRoles();
    }
}
