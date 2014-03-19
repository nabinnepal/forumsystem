package forumsystem.data;

import forumsystem.entities.Thread;
import com.google.common.base.Predicate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.google.common.collect.Iterables.find;
import static com.google.common.collect.Lists.newArrayList;
import static java.lang.Integer.valueOf;


@Repository
public class DefaultThreadRepository implements ThreadRepository {
    public Iterable<forumsystem.entities.Thread> findAll(){
        return threads();
    }

    public Thread findThreadById(final String id){
        return find(threads(), new Predicate<Thread>() {
            @Override
            public boolean apply(Thread input) {
                return input.getId() == valueOf(id);
            }
        }, null);
    }

    private List<Thread> threads(){
        Thread thread = new Thread();
        thread.setTitle("First thread");
        thread.setDescription("First thread description");
        thread.setId(1);
        Thread thread2 = new Thread();
        thread2.setTitle("Second thread");
        thread2.setDescription("Second thread description");
        thread2.setId(2);
        return newArrayList(thread, thread2);
    }
}
