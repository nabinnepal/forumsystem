package data;

import java.util.Map;

public interface ForumRepository {
    Iterable<Map<String, Object>> findAll();
}
