package spannerapp.dao;

import spannerapp.model.UserRole;

import java.util.List;

/**
 * Created by Siekacz on 04.06.2017.
 */
public interface IUserRoleDAO {
    public List<UserRole> getAllUserRoles();
}
