package xyz.yuanzhi.paganiniserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.yuanzhi.paganiniserver.domain.Admin;
import xyz.yuanzhi.paganiniserver.service.AdminServiceImpl;
import xyz.yuanzhi.paganiniserver.util.JacksonUtil;
import xyz.yuanzhi.paganiniserver.util.Message;

@RestController
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping(value = "/admin/login")
    public String userLogin(@RequestBody Admin admin){
        Message message = new Message();
        String name = admin.getName();
        String password = admin.getPassword();
        message.addMessage(adminService.searchAdmin(name, password), "登录成功", "用户名或密码错误");
        return message.toJson();
    }

}
