package xyz.yuanzhi.paganiniserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.yuanzhi.paganiniserver.domain.Admin;
import xyz.yuanzhi.paganiniserver.service.AdminServiceImpl;
import xyz.yuanzhi.paganiniserver.util.Message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping(value = "/admin/login")
    public String userLogin(HttpServletRequest req, HttpSession session){
        Message message = new Message();
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        message.addMessage(adminService.searchAdmin(name, password), "登录成功", "用户名或密码错误");
        session.setAttribute("name", name);
        return message.toJson();
    }

}
