package data;

import Entities.Thread;

public interface ThreadRepository {
    Iterable<Thread> findAll();
    Thread findThreadById(final String id);
}
