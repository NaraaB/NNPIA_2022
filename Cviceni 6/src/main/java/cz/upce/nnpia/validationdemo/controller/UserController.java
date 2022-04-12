package cz.upce.nnpia.validationdemo.controller;

import cz.upce.nnpia.validationdemo.dto.UserDto;
import cz.upce.nnpia.validationdemo.entity.User;
import cz.upce.nnpia.validationdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/registering")
    public String registerForm(@Valid UserDto userDto, Errors errors){
        if(errors.hasErrors()){
            return "register";
        }else{
            User user = new User();
            user.setFullName(userDto.getFullName());
            user.setUserId(userDto.getId());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            user.setType(userDto.getType());

            userRepository.save(user);
            return "redirect:/register";
        }
    }
}
