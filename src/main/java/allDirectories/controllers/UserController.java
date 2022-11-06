package allDirectories.controllers;

import allDirectories.models.User;
import allDirectories.service.UserServiceHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
   private final UserServiceHibernate userServiceHibernate;

    @Autowired
    public UserController(UserServiceHibernate userServiceHibernate) {
        this.userServiceHibernate = userServiceHibernate;
    }


    @GetMapping("/showUsers")
    public String showUsers(Model model) {
        model.addAttribute("people", userServiceHibernate.show());
        return "showUsers";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user) {
        userServiceHibernate.add(user);
        return "redirect:/showUsers";
    }

//    @GetMapping("/delete")
//    public String deleteUser(Model model) {
//        model.addAttribute("people", userDao.show());
//        return "delete";
//    }

//    @DeleteMapping("delete/{id}")
//    public String deleteUserInDataBase(@PathVariable int id) {
//        userDao.delete(id);
//        return "redirect:/showUsers";
//    }

    @GetMapping("showUser/{id}")
    public String id(@PathVariable int id, Model model) {
        model.addAttribute("user", userServiceHibernate.get(id));
        return "user";
    }

    @GetMapping("{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userServiceHibernate.get(id));
        return "edit";
    }
    @PatchMapping("/{id}")
    public String patchEdit(@ModelAttribute("user") User user,
                            @PathVariable("id") int id) {
        userServiceHibernate.update(id, user);
        return "redirect:/showUsers";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userServiceHibernate.delete(id);
        return "redirect:/showUsers";
    }
}


