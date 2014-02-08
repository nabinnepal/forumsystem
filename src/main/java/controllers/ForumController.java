package controllers;

import com.google.common.collect.ImmutableMap;
import data.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;

@Controller
@RequestMapping("/forums")
public class ForumController {
    private ForumRepository forumRepository;

    @Autowired
    public ForumController(ForumRepository forumRepository){
        this.forumRepository = forumRepository;
    }
    @RequestMapping("/")
    public ResponseEntity getForums(){
        Iterable<Map<String,Object>> all = forumRepository.findAll();
        ImmutableMap<String,Iterable<Map<String,Object>>> forums = of("forums", all);
        return new ResponseEntity(all, HttpStatus.OK);
    }
}
