package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dto.LoginDto;
import pl.coderslab.dto.RegisterDto;
import pl.coderslab.model.Role;
import pl.coderslab.model.User;
import pl.coderslab.repositories.RoleRepository;
import pl.coderslab.repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("registerDto", new RegisterDto());
        return "forms/register";
    }


    @PostMapping("/register")
    public String saveUserFromRegistrationForm(@Valid RegisterDto registerDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "forms/register";
        }


        if (!registerDto.getPassword().equals(registerDto.getPassword2())) {
            bindingResult.addError(new FieldError("registerDto", "password", "Haslo nie jest jednakowe"));
            bindingResult.addError(new FieldError("registerDto", "password2", "Haslo nie jest jednakowe"));
            return "forms/register";
        }
        if (userRepository.findUserByEmail(registerDto.getEmail())!=null){
            bindingResult.addError(new FieldError("registerDto", "email", "Email juz istnieje w bazie"));
            return "forms/register";
        }

        User user = new User();

        user.setEmail(registerDto.getEmail());
        user.setTokens(0);
        user.setHashedPassword(registerDto.getPassword());

        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findById(3L));
        user.setRoles(new HashSet<>(roles));
        userRepository.save(user);

        //TODO zmienić
        return "redirect:/admin/users/all";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model){
        model.addAttribute("loginDto", new LoginDto());
        return "forms/login";
    }


    @PostMapping("/login")
    public String postLogin(@ModelAttribute LoginDto loginDto, HttpServletRequest request){
        User user = userRepository.findUserByEmail(loginDto.getEmail());
        if (user == null){
            return "Nie ma takiego usera w bazie danych";
        }

        String userPassword = user.getPassword();
        boolean checkpw = BCrypt.checkpw(loginDto.getPassword(), userPassword);

        if (checkpw) {
            request.getSession(true).setAttribute("loggedIn", true);
            return "OK";
        }else {
            return "Zle haslo";
        }

    }



}
