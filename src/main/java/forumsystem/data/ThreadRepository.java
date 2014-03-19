package forumsystem.data;

import forumsystem.entities.Thread;

public interface ThreadRepository {
    Iterable<Thread> findAll();
    Thread findThreadById(final String id);
}
