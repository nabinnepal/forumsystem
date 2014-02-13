package data;

import java.util.Map;

public interface ThreadRepository {
    Iterable<Map<String, Object>> findAll();
    Map<String, Object> findThreadById(final String id);
}
