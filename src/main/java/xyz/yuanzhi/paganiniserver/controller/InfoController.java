package xyz.yuanzhi.paganiniserver.controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.yuanzhi.paganiniserver.service.SingerServiceImpl;
import xyz.yuanzhi.paganiniserver.service.SongServiceImpl;
import xyz.yuanzhi.paganiniserver.service.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

@RestController
public class InfoController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private SongServiceImpl songService;

    @Autowired
    private SingerServiceImpl singerService;

    @SneakyThrows
    @GetMapping(value = "/info")
    public String getInfo(){
        JsonNodeFactory factory = new JsonNodeFactory(false);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode result = factory.objectNode();

        long count = userService.countAll();
        long man = userService.countBySex(true);
        long woman = userService.countBySex(false);
        ObjectNode user = factory.objectNode().put("count", count)
                .put("man", man)
                .put("woman", woman)
                .put("unknown", count - man - woman);

        ObjectNode song = factory.objectNode().put("count", songService.countAll());

        count = userService.countAll();
        man = userService.countBySex(true);
        woman = userService.countBySex(false);
        ObjectNode singer = factory.objectNode().put("count", count)
                .put("man", man)
                .put("woman", woman)
                .put("unknown", count - man - woman);

        result.set("user", user);
        result.set("song", song);
        result.set("singer", singer);
        return String.valueOf(result);
    }

}
