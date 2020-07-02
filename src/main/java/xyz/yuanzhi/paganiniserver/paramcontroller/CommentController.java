package xyz.yuanzhi.paganiniserver.paramcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.yuanzhi.paganiniserver.domain.Comment;
import xyz.yuanzhi.paganiniserver.service.CommentServiceImpl;
import xyz.yuanzhi.paganiniserver.util.Message;

import java.util.List;

@RestController
@RequestMapping(value = "/web/comment/")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @GetMapping(value = "songId={songId}")
    public String getAllComment(@PathVariable Integer songId){
        List<Comment> comments = commentService.getAllComment(songId);
        Message message = new Message();
        message.addSuccessMsg("成功获取评论");
        message.setObject(comments);
        return message.toJson();
    }

    @PostMapping(value = "add")
    public String addComment(@RequestBody Comment comment){
        Message message = new Message();
        message.setObject(commentService.addComment(comment));
        message.addSuccessMsg("成功添加评论");
        return message.toJson();
    }

    @PutMapping(value = "modify")
    public String modifyComment(@RequestBody Comment comment){
        Message message = new Message();
        commentService.addComment(comment);
        message.addSuccessMsg("成功修改评论");
        return message.toJson();
    }

    @DeleteMapping(value = "delete/commentId={commentId}")
    public String deleteComment(@PathVariable Integer commentId){
        commentService.deleteComment(commentId);
        Message message = new Message();
        message.addSuccessMsg("删除成功");
        return message.toJson();
    }
}
