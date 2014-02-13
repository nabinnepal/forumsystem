package controllers;

import data.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;

@Controller
public class ForumController {
    private ThreadRepository forumRepository;

    @Autowired
    public ForumController(ThreadRepository forumRepository){
        this.forumRepository = forumRepository;
    }

    @RequestMapping(value= "/allforums")
    public @ResponseBody Iterable<Map<String,Object>> getForums(){
        return forumRepository.findAll();
    }

    @RequestMapping(value="/forums/{id}")
    public ModelAndView getForumById(@PathVariable(value="id") String id){
        Map<String, Object> threadDetails = forumRepository.findThreadById(id);
        return new ModelAndView("details", "forumDetails", threadDetails);
    }

    @RequestMapping("/forums")
    public String getForumTemplate(){
        return "index";
    }
}
