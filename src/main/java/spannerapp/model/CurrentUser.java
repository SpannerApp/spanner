package spannerapp.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by Siekacz on 02.06.2017.
 */
public class CurrentUser extends User {

    private static final long serialVersionUID = 1L;
    private LoggedUser loggedUser;
    private LoggedUser delegate;

    public CurrentUser(LoggedUser loggedUser, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities)
    {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.loggedUser = loggedUser;
    }

    public CurrentUser(LoggedUser user, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.loggedUser = loggedUser;
    }

    public LoggedUser getCurrentUser(){
        if(delegate != null)
            return delegate;
        else
            return loggedUser;
    }

    public LoggedUser getLoggedUser() {
        return loggedUser;
    }

    public LoggedUser getDelegate() {
        return delegate;
    }

    public void setDelegate(LoggedUser delegate) {
        this.delegate = delegate;
    }
}
