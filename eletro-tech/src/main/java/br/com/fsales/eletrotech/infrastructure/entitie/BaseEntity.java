package br.com.fsales.eletrotech.infrastructure.entitie;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {

    @CreatedDate
    private Instant created;

    @LastModifiedDate
    private Instant updated;

    public Instant getCreated() {
        return created;
    }

    public BaseEntity setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getUpdated() {
        return updated;
    }

    public BaseEntity setUpdated(Instant updated) {
        this.updated = updated;
        return this;
    }

}
