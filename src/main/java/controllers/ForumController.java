package controllers;

import data.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ForumController {
    private ThreadRepository forumRepository;

    @Autowired
    public ForumController(ThreadRepository forumRepository){
        this.forumRepository = forumRepository;
    }

    @RequestMapping("/forums")
    public String getForumTemplate(){
        return "index";
    }

    @RequestMapping(value="/forums/{id}")
    public ModelAndView getForumById(@PathVariable(value="id") String id){
        Entities.Thread threadDetails = forumRepository.findThreadById(id);
        if(threadDetails != null)
            return new ModelAndView("details", "forumDetails", threadDetails);
        throw new ResourceNotFoundException();
    }

    @RequestMapping(value= "/allforums")
    public @ResponseBody Iterable<Entities.Thread> getForums(){
        return forumRepository.findAll();
    }
}
