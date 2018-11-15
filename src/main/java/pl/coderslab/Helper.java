package pl.coderslab;

import pl.coderslab.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Helper {

    public static User getUserFromSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        return user;
    }
}
