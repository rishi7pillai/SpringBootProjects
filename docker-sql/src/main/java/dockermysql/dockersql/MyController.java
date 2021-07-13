package dockermysql.dockersql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private RegisterDao registerDao;

    //user register
    @PostMapping("/register")
    public Register addUser(@RequestBody Register register){
        return registerDao.save(register);
    }


    @GetMapping("/get")
    public List<Register> getUser(){
        return registerDao.findAll();
    }

    @DeleteMapping("/deleteuser/{userId}")
    public void deleteUser(@PathVariable Long userId){
        Register register = registerDao.findByuserId(userId);
        registerDao.delete(register);

    }

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/greet")
    public String greet(){
        return "hello world greetings";
    }

}
