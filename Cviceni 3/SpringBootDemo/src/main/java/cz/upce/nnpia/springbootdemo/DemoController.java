package cz.upce.nnpia.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.Locale;

@Controller
public class DemoController {
    @Autowired
    private VisitorCounterService vcs;

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String requestGreetingParam(@RequestParam
                                               (name = "name",
                                                       required = false,
                                                       defaultValue = "Dear")
                                               String name, Model model){
        vcs.increment();
        model.addAttribute("name", StringUtils.toUpperCase(name, Locale.ENGLISH));
        model.addAttribute("visitorCounter", vcs.getCounter());
        return "welcome";
    }
    @RequestMapping(value = "/welcome/{name}", method = RequestMethod.GET)
    public String requestGreetingVar(@PathVariable("name") String userName, Model model){
        vcs.increment();
        model.addAttribute("name", StringUtils.toUpperCase(userName, Locale.ENGLISH));
        model.addAttribute("visitorCounter", vcs.getCounter());
        return "welcome";
    }
    @GetMapping(value = "/registration")
    public String showForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }
    @PostMapping(value = "/registration")
    public String submitForm(@ModelAttribute("user") User user){
        return "result";
    }

}
