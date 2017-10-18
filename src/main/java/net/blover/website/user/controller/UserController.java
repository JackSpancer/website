package net.blover.website.user.controller;

import net.blover.website.framework.BaseController;
import net.blover.website.user.domain.User;
import net.blover.website.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserById.do")
    @ResponseBody
    public Map<String, Object> getUserById(String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        User user = userService.getById(id);
        map.put("user", user);
        return map;
    }
}
