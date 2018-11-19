package pl.coderslab;

import pl.coderslab.model.Role;
import pl.coderslab.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Set;

public class Helper {

    // Checking if Object User is already in session (should be if logged)
    // Returns User object

    public static User getUserFromSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        return user;
    }

    // Checking if User stored in session has Admin role

    public static boolean checkIfAdmin(HttpServletRequest request){
        User user = getUserFromSession(request);
        if (user != null) {

            Set<Role> roles = user.getRoles();

            for (Role role : roles) {
                if ("admin".equals(role.getRoleName())) {
                    return true;
                }
            }
        }
    return false;
    }
}
