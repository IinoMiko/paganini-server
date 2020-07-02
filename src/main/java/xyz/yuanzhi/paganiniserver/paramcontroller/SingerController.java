package xyz.yuanzhi.paganiniserver.paramcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.yuanzhi.paganiniserver.domain.Singer;
import xyz.yuanzhi.paganiniserver.service.SingerServiceImpl;
import xyz.yuanzhi.paganiniserver.util.Message;

@RestController
@RequestMapping(value = "/web/singer/")
public class SingerController {

    @Autowired
    private SingerServiceImpl singerService;

    @GetMapping(value = "singerId={singerId}")
    public String getSingerById(@PathVariable Integer singerId){
        Message message = new Message();
        Singer singer = singerService.getSingerById(singerId);
        if(singer == null){
            message.addFailMsg("获取歌手信息失败");
            message.setObject(new Singer());
        } else {
            message.addSuccessMsg("成功获取歌手信息");
            message.setObject(singer);
        }
        return message.toJson();
    }

    @GetMapping(value = "all")
    public String getAllSinger(){
        Message message = new Message();
        message.addSuccessMsg("获取成功");
        message.setObject(singerService.getAllSingers());
        return message.toJson();
    }

    @PutMapping(value = "modify")
    public String modify(@RequestBody Singer singer){
        singerService.save(singer);
        Message message = new Message();
        message.addSuccessMsg("成功");
        return message.toJson();
    }

    @PostMapping(value = "add")
    public String addSinger(@RequestBody Singer singer){
        Message message = new Message();
        message.setObject(singerService.save(singer));
        message.addSuccessMsg("添加成功");
        return message.toJson();
    }

    @DeleteMapping(value = "singerId={singerId}")
    public String deleteSinger(@PathVariable Integer singerId){
        singerService.deleteAllBySingerId(singerId);
        Message message = new Message();
        message.addSuccessMsg("成功删除");
        return message.toJson();
    }

}
