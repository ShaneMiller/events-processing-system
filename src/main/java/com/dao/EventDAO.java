package com.dao;

import com.model.Event;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class EventDAO extends AbstractDAO {

    public void save(final Event event) {
        getCurrentSession().save(event);
    }

    public Collection<Event> findAll() {
        Query query = getCurrentSession().createQuery("from Event e");
        return (List<Event>)query.list();
    }

    public Event findByPrimaryKey(Long id) {
        Query query = getCurrentSession().createQuery("from Event e where e.id = :id");
        query.setLong("id", id);
        return (Event)query.uniqueResult();
    }
}
