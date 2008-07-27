package org.localstorm.mcc.ejb.tasks;

import java.util.Collection;
import java.util.Date;
import org.localstorm.mcc.ejb.contexts.Context;
import org.localstorm.mcc.ejb.except.DuplicateException;
import org.localstorm.mcc.ejb.except.ObjectNotFoundException;
import org.localstorm.mcc.ejb.lists.GTDList;
import org.localstorm.mcc.ejb.users.User;

/**
 *
 * @author Alexey Kuznetsov
 */
public interface TaskManager 
{
    public void createTask(Task task) throws DuplicateException;
    
    public void updateTask(Task task);
    
    public Task findById( int id ) throws ObjectNotFoundException;

    
    //TODO!
    /* Doesn't return archived contexts */
    public Collection<Task> findByList(GTDList l);
    
    /* Doesn't return archived contexts */
    public Collection<Task> findByContext(Context ctx);
    
    
    /**
     * redline or deadline maybe null
     */
    public Collection<Task> findByUserAndLines(User user, Date redLine, Date deadLine);

    /**
     * redline or deadline maybe null
     */
    public Collection<Task> findIncompleteByUserAndLines(User user, Date redLine, Date deadLine);
    
    public Collection<Task> findDelegatedByUserAndLines(User user, Date redLine, Date deadLine);
    
    public Collection<Task> findStartedByUserAndLines(User user, Date redLine, Date deadLine);
    
    public Collection<Task> findPausedByUserAndLines(User user, Date redLine, Date deadLine);

}