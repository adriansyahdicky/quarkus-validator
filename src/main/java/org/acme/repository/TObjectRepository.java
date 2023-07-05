package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.TObject;


@ApplicationScoped
public class TObjectRepository implements PanacheRepository<TObject> {
    public TObject findByNameKey(String nameKey){
        return find("nameKey", nameKey).firstResult();
    }
}
