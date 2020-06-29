package xyz.yuanzhi.paganiniserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.yuanzhi.paganiniserver.service.CollectServiceImpl;
import xyz.yuanzhi.paganiniserver.util.Message;

@RestController
@RequestMapping(value = "/systemList/")
public class SystemListController {

    @Autowired
    private CollectServiceImpl collectService;

    @GetMapping(value = "getAll")
    public String getAllSystemList(){
        Message message = new Message();
        message.setObject(collectService.getAllSystemList());
        message.addSuccessMsg("获取系统歌单成功");
        return message.toJson();
    }

}
