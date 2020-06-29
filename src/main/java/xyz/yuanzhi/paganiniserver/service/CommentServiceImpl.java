package xyz.yuanzhi.paganiniserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import xyz.yuanzhi.paganiniserver.dao.CommentRepository;
import xyz.yuanzhi.paganiniserver.domain.Comment;

import java.util.List;

@Service
public class CommentServiceImpl {

    @Autowired
    private CommentRepository repository;

    public List<Comment> getAllComment(Integer songId){
        return repository.findAllBySongId(songId);
    }

    public Comment addComment(Comment comment){
        return repository.save(comment);
    }

    public void deleteComment(Integer commentId){
        repository.deleteAllByCommentId(commentId);
    }

}
