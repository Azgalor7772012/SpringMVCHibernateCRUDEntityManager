package allDirectories.controllers;

import allDirectories.dao.UserDaoHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final UserDaoHibernate userDao;

    @Autowired
    public UserController(UserDaoHibernate userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/showUsers")
    public String showUsers(Model model) {
        model.addAttribute("people", userDao.show());
        return "showUsers";
    }
}
