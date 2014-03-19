import forumsystem.entities.Thread;
import com.google.common.collect.Lists;
import forumsystem.controllers.ForumController;
import forumsystem.controllers.ResourceNotFoundException;
import forumsystem.data.ThreadRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ForumControllerTest {

    @Mock
    ThreadRepository repository;

    @Test
    public void should_get_all_forums(){
        when(repository.findAll()).thenReturn(Lists.newArrayList(new Thread()));
        ForumController controller = new ForumController(repository);
        Iterable<Thread> resultBody = controller.getForums();
        assertEquals(true, resultBody.iterator().hasNext());
    }

    @Test
    public void should_get_forum_template(){
        ForumController forumController = new ForumController(repository);
        assertEquals("index", forumController.getForumTemplate());
    }

    @Test
    public void should_get_forum_details(){
        when(repository.findThreadById(Matchers.eq("1"))).thenReturn(new Thread());
        ForumController forumController = new ForumController(repository);
        assertNotNull(forumController.getForumById("1"));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void should_throw_404_when_no_thread_is_found(){
        when(repository.findThreadById(Matchers.eq("1"))).thenReturn(new Thread());
        ForumController forumController = new ForumController(repository);
        forumController.getForumById("2");
    }
}
