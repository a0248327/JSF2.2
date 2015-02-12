package at.irian.jsfatwork.service;

import at.irian.jsfatwork.dao.CrudService;
import at.irian.jsfatwork.domain.BaseEntity;
import org.apache.myfaces.extensions.cdi.jpa.api.Transactional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class FinderService {
    @Inject
    private CrudService crudService;

    @Transactional
    public <T extends BaseEntity> T find(Class<T> clazz, long id) {
        return crudService.findById(clazz, id);
    }

    @Transactional
    public <T extends BaseEntity> List<T> findAll(Class<T> clazz) {
        return crudService.findAll(clazz);
    }

}
