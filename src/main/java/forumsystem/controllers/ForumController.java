package forumsystem.controllers;

import forumsystem.data.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ForumController {
    private ThreadRepository threadRepository;

    @Autowired
    public ForumController(ThreadRepository threadRepository){
        this.threadRepository = threadRepository;
    }

    @RequestMapping("/forums")
    public String getForumTemplate(){
        return "index";
    }

    @RequestMapping(value="/forums/{id}")
    public ModelAndView getForumById(@PathVariable(value="id") String id){
        forumsystem.entities.Thread threadDetails = threadRepository.findThreadById(id);
        if(threadDetails != null)
            return new ModelAndView("details", "forumDetails", threadDetails);
        throw new ResourceNotFoundException();
    }

    @RequestMapping(value= "/allforums")
    public @ResponseBody Iterable<forumsystem.entities.Thread> getForums(){
        return threadRepository.findAll();
    }
}
