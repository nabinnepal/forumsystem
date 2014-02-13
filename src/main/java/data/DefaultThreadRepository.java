package data;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;

public class DefaultThreadRepository implements ThreadRepository {
    private static final List<Map<String, Object>> threads =   Lists.<Map<String,Object>>newArrayList(of("title", (Object) "test", "description", "Description body", "id", 1),
            of("title", (Object) "test2", "description", "test 2 Description body", "id", 2));

    public Iterable<Map<String, Object>> findAll(){
        return threads;
    }

    public Map<String, Object> findThreadById(final String id){
        return Iterables.find(threads, new Predicate<Map<String, Object>>() {
            @Override
            public boolean apply(Map<String, Object> input) {
                return String.valueOf(input.get("id")).equals(id);
            }
        });
    }
}
