import com.google.common.collect.Lists;
import controllers.ForumController;
import data.ForumRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ForumControllerTest {

    @Mock
    ForumRepository repository;

    @Test
    public void should_get_all_forums(){
        when(repository.findAll()).thenReturn(Lists.<Map<String,Object>>newArrayList(of("title", (Object) "test", "description", "Description body")));
        ForumController controller = new ForumController(repository);
        ResponseEntity result = controller.getForums();
        Iterable<Map<String, Object>> resultBody = (Iterable<Map<String, Object>>) result.getBody();
        assertEquals(true, resultBody.iterator().hasNext());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}
