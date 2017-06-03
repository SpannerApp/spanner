package spannerapp.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import spannerapp.factory.ServiceFactory;
import spannerapp.model.CurrentUser;

import java.io.Serializable;

/**
 * Created by Siekacz on 02.06.2017.
 */
public class SessionController implements Serializable {

    ServiceFactory serviceFactory = new ServiceFactory();
    private static final long serialVersionUID = 1L;

    private String systemMessage;
    private String text;
    private CurrentUser currentUser;

    public CurrentUser getUser()
    {
        if(currentUser==null)
        {
            currentUser=(CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            currentUser.getCurrentUser().setEmployee(serviceFactory.getEmployeeService().find(activeUser.getUser().getEmployee().getId(), getAuthContext()));
        }
        return currentUser;
    }
}
