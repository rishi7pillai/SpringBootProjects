package com.smartmanager.smartmanager.controller;




import com.smartmanager.smartmanager.dao.UserRepoDao;
import com.smartmanager.smartmanager.helper.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.smartmanager.smartmanager.entity.UserInfo;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    
    private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();;

    @Autowired
    private UserRepoDao userRepoDao;

    
    @RequestMapping("/")
    public String home(Model model){
         model.addAttribute("title","Home-Smart Manager");
         return "home";
    }

    @RequestMapping("/about")
    public String about(Model model){
        model.addAttribute("title","About-Smart Manager");
        return "about";
    }
    
    @RequestMapping("/signup")
    public String signup(Model model){
        model.addAttribute("title","Register-Smart Manager");
        model.addAttribute("user", new UserInfo());
        return "signup";
    }
    
    //handler for user registration
    @RequestMapping(value="/do_register",method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") UserInfo user, BindingResult result1, @RequestParam(value="agreement",defaultValue="false") boolean agreement, Model model,
                               HttpSession session) {

        try{
            if(!agreement){
                System.out.println("You have not agreed terms and conditions");
                throw new Exception("You have not agreed terms and conditions");
            }
            
            if(result1.hasErrors()) {
            	System.out.println("ERROR "+result1.toString());
            	model.addAttribute("user",user);
            	return "signup";
            }
            
            user.setRole("ROLE_USER");
            user.setEnabled(true);
            user.setImageUrl("default.png");
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            System.out.println("Agreement "+agreement);
            System.out.println("USER"+user.toString());

            userRepoDao.save(user);

            model.addAttribute("user",new UserInfo());
            session.setAttribute("message",new Message("Successfully Registered!!!","alert-success"));
            return "signup";

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("user",user);
            session.setAttribute("message",new Message("something went wrong!!!"+e.getMessage(),"alert-danger"));
            return "signup";

        }


    }
  
    @GetMapping("/signin")
    public String login(Model model){
         model.addAttribute("title","login page");
         return "login";
    }
    
}
