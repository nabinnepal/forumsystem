package data;

import Entities.*;
import Entities.Thread;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;
import static com.google.common.collect.Lists.newArrayList;

public class DefaultThreadRepository implements ThreadRepository {
    public Iterable<Entities.Thread> findAll(){
        return threads();
    }

    public Thread findThreadById(final String id){
        return Iterables.find(threads(), new Predicate<Thread>() {
            @Override
            public boolean apply(Thread input) {
                return input.getId()== Integer.valueOf(id);
            }
        });
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
