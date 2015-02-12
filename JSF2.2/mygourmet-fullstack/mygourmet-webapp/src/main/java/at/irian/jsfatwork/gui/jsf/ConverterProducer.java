package at.irian.jsfatwork.gui.jsf;

import at.irian.jsfatwork.domain.Category;
import at.irian.jsfatwork.domain.Provider;
import at.irian.jsfatwork.service.FinderService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

/**
 *
 */
@ApplicationScoped
public class ConverterProducer {

    @Produces @Named
    public EntityConverter<Category> getCategoryConverter(FinderService finderService) {
        return new EntityConverter<Category>(finderService, Category.class);
    }

    @Produces @Named
    public EntityConverter<Provider> getProviderConverter(FinderService finderService) {
        return new EntityConverter<Provider>(finderService, Provider.class);
    }

}
