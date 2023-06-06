package de.vkononenko.TacoCloud.models.base;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public class EntityBase implements Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    protected Date dateCreated;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateUpdated;

    @PrePersist
    protected void create() {
        dateCreated = new Date();
    }

    @PreUpdate
    protected void update() {
        dateUpdated = new Date();
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }
}
