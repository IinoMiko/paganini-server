package xyz.yuanzhi.paganiniserver.paramcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.yuanzhi.paganiniserver.domain.Collect;
import xyz.yuanzhi.paganiniserver.domain.Song;
import xyz.yuanzhi.paganiniserver.domain.SongList;
import xyz.yuanzhi.paganiniserver.service.CollectServiceImpl;
import xyz.yuanzhi.paganiniserver.service.SongListServiceImpl;
import xyz.yuanzhi.paganiniserver.service.SongServiceImpl;
import xyz.yuanzhi.paganiniserver.util.Message;
import xyz.yuanzhi.paganiniserver.util.MyJson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/web/collect/")
public class CollectController {

    @Autowired
    private CollectServiceImpl collectService;

    @Autowired
    private SongServiceImpl songService;

    @Autowired
    private SongListServiceImpl songListService;

    @GetMapping(value = "userId={userId}")
    public String getAllCollects(@PathVariable Integer userId){
        List<Collect> collects = collectService.getAllCollects(userId);
        Message message = new Message();
        message.addMessage(!collects.isEmpty(), "歌单如下", "找不到歌单");
        message.setObject(collects);
        return message.toJson();
    }

    @PostMapping(value = "addCollect")
    public String addUserCollect(@RequestParam Collect collect){
        collect.setType(Collect.USER_LIST); //设置为用户歌单
        collect.setCreateTime(new Date());
        Collect newCollect = collectService.addCollect(collect);
        Message message = new Message();
        message.addMessage(newCollect != null, "成功添加", "添加失败");
        message.setObject(newCollect);
        return message.toJson();
    }

    @PostMapping(value = "addSystemList")
    public String addSystemList(@RequestBody Collect collect){
        collect.setType(Collect.SYSTEM_LIST); //设置为系统歌单
        collect.setCreateTime(new Date());
        Collect newCollect = collectService.addCollect(collect);
        Message message = new Message();
        message.addMessage(newCollect != null, "成功添加", "添加失败");
        message.setObject(newCollect);
        return message.toJson();
    }

    @PostMapping(value = "addSong/collectId={collectId}&songId={songId}")
    public String addSongToCollect(@PathVariable Integer collectId, @PathVariable Integer songId){
        Message message = new Message();
        if(collectService.existsByCollectId(collectId) && songService.existsBySongId(songId)){
            songListService.addSongToCollect(new SongList(collectId, songId));
            message.addSuccessMsg("成功添加歌曲");
        } else {
            message.addFailMsg("歌单或歌曲不存在");
        }
        return message.toJson();
    }

    @PutMapping(value = "modifyCollect")
    public String modifyCollect(@RequestBody Collect collect){
        collect.setType(Collect.USER_LIST); //设置为用户歌单，防止手贱
        collectService.addCollect(collect);
        Message message = new Message();
        message.addSuccessMsg("修改成功");
        return message.toJson();
    }

    @DeleteMapping(value = "deleteSong/collectId={collectId}&songId={songId}")
    public String removeSongFromCollect(@PathVariable Integer collectId, @PathVariable Integer songId){
        Message message = new Message();
        if(collectService.existsByCollectId(collectId) && songService.existsBySongId(songId)){
            songListService.deleteSongFromCollect(collectId, songId);
            message.addSuccessMsg("成功删除歌曲");
        } else {
            message.addFailMsg("歌单或歌曲不存在");
        }
        return message.toJson();
    }

    @DeleteMapping(value = "deleteCollect/collectId={collectId}")
    public String removeCollect(@PathVariable Integer collectId){
        collectService.deleteByCollectId(collectId);
        Message message = new Message();
        message.addSuccessMsg("删除成功");
        return message.toJson();
    }

    @GetMapping(value = "collectId={collectId}")
    public String getAllSongs(@PathVariable Integer collectId){
        List<Integer> songIds = songListService.getAllByCollectId(collectId);
        List<Song> songs = new ArrayList<>();
        System.out.println(songIds);
        for (Integer songId : songIds) {
            songs.add(songService.getSongById(songId));
        }
        Message message = new Message();
        message.addSuccessMsg("获取成功");
        message.setObject(songs);
        return message.toJson();
    }

    @GetMapping(value = "style={style}")
    public String getCollectsByStyle(@PathVariable String style){
        List<Collect> collects = collectService.getAllByStyle(style);
        Message message = new Message();
        message.addSuccessMsg("获取成功");
        message.setObject(collects);
        return message.toJson();
    }

}
