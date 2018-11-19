package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Helper;
import pl.coderslab.dto.UserDto;
import pl.coderslab.model.Role;
import pl.coderslab.model.Technique;
import pl.coderslab.model.User;
import pl.coderslab.repositories.RoleRepository;
import pl.coderslab.repositories.TechniqueRepository;
import pl.coderslab.repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TechniqueRepository techniqueRepository;

    @RequestMapping("/all")
    private String showAllUsers(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "usersShowAll";
    }

    @GetMapping("/add")
    private String showUserAddForm(Model model){
        model.addAttribute("userDto", new UserDto());
        return "forms/userAdd";
    }

    @PostMapping("/add")
    private String saveUser(@Valid UserDto userDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "forms/userAdd";
        }
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setNote(userDto.getNote());
        user.setTokens(userDto.getTokens());
        user.setHashedPassword(userDto.getPassword());
        user.setRoles(userDto.getRoles());
        user.setTechniques(userDto.getTechniques());
        userRepository.save(user);
    return "redirect:/admin/users/all";
    }

    @GetMapping("/edit/{id}")
    private String editUser(@PathVariable Long id, Model model){
        User user = userRepository.findOne(id);
        model.addAttribute("user", user);

       return "forms/userEdit";
    }

    @PostMapping("/edit/{id}")
    private String saveEditedUser(@Valid User user, @PathVariable Long id, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "forms/userEdit";
        }

        user.setId(id);
        userRepository.save(user);

        return "redirect:/admin/users/all";
    }


    @RequestMapping("/delete/{id}")
    private String deleteUser(@PathVariable Long id){
        userRepository.delete(userRepository.getOne(id));
        return "redirect:/admin/users/all";
    }

    @RequestMapping("/addtokens/{id}/{tokens}")
    private String addTokensToUsers (@PathVariable int tokens, @PathVariable Long id){
        User user = userRepository.findOne(id);
        user.setTokens(user.getTokens() + tokens);
        userRepository.save(user);


        return "redirect:/admin/users/all";
    }

    // TODO: chyba niepotrzebne, można podawać jako parameter -1 do metody powyżej

    @RequestMapping("/substracttokens/{id}/{tokens}")
    private String substractTokensFromUsers (@PathVariable int tokens, @PathVariable Long id){
        User user = userRepository.findOne(id);
        user.setTokens(user.getTokens() - tokens);
        userRepository.save(user);


        return "redirect:/admin/users/all";
    }

    @ModelAttribute("roles")
    private List<Role> findAllRoles(){
        List<Role> roles = roleRepository.findAll();
        return roles;
    }

    @ModelAttribute("techniques")
    private List<Technique> findAllTechniques(){
        List<Technique> techniques = techniqueRepository.findAll();
        return techniques;
    }

    @ModelAttribute("user")
    public User getUser(HttpServletRequest request){
        return Helper.getUserFromSession(request);
    }

    @ModelAttribute("isAdmin")
    public boolean checkIfAdmin(HttpServletRequest request){
        return Helper.checkIfAdmin(request);
    }

}
