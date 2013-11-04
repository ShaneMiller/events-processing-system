package com.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Audited
@Entity
@Table(name = "event")
@XmlRootElement(name = "event")
@Path("/")
public class Event {

    private Long id;
    private String type;
    private String value;
    private Date created;

    public Event() {
    }

    public Event(String type, String value, Date created) {
        this.type = type;
        this.value = value;
        this.created = created;
    }

    @GET
    @Produces("application/xml")
    @Transient
    public Event get()
    {
        return this;
    }


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @XmlAttribute(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
