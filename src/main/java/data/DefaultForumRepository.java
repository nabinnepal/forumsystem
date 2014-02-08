package data;

import com.google.common.collect.Lists;

import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;

public class DefaultForumRepository implements ForumRepository {
    public Iterable<Map<String, Object>> findAll(){
        return Lists.<Map<String,Object>>newArrayList(of("title", (Object) "test", "description", "Description body"));
    }
}
