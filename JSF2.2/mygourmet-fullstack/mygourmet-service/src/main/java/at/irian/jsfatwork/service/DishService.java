package at.irian.jsfatwork.service;

import at.irian.jsfatwork.dao.CrudService;
import at.irian.jsfatwork.domain.Dish;
import at.irian.jsfatwork.domain.Provider;
import org.apache.myfaces.extensions.cdi.jpa.api.Transactional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DishService {

    @Inject
    private CrudService crudService;

    public Dish createNew() {
        return crudService.createNew(Dish.class);
    }

    @Transactional
    public void save(Provider provider, Dish dish) {
        if (dish.isTransient()) {
            Provider mergedProvider = crudService.merge(provider);
            mergedProvider.addDish(dish);
            crudService.persist(dish);
        } else {
            crudService.merge(dish);
        }
    }

    @Transactional
    public void delete(Dish dish) {
        Provider provider = dish.getProvider();
        if (provider != null) {
            provider.getDishes().remove(dish);
        }
        crudService.merge(provider);
        dish = crudService.merge(dish);
        crudService.delete(dish);
    }

}
