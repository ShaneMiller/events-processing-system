package com.api.services;

import com.dao.EventDAO;
import com.model.Event;
import com.model.Events;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "events")
@Path("/api/events")
@Component
@Transactional
public class EventsRestService {

    @Resource
    private EventDAO eventDAO;

    @GET
    @Path("/")
    @Produces("application/xml")
    public Events getAllEvents() {
        Events events = new Events();
        events.setEvents(eventDAO.findAll());
        return events;
    }

    @GET
    @Path("/{id}")
    @Produces("application/xml")
    public Event findByPrimaryKey(@PathParam("id") Long id) {
        return eventDAO.findByPrimaryKey(id);
    }

    @POST
    @Path("/create")
    @Produces("application/xml")
    public Event createEvent() {
        Event event = new Event("test", "created new event through transactional API", new Date());
        eventDAO.save(event);
        return event;
    }


}