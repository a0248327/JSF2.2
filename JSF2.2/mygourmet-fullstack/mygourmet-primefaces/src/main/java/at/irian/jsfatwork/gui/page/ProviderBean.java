package at.irian.jsfatwork.gui.page;

import at.irian.jsfatwork.domain.Category;
import at.irian.jsfatwork.domain.Dish;
import at.irian.jsfatwork.domain.Provider;
import at.irian.jsfatwork.gui.jsf.navigation.NavigationResolver;
import at.irian.jsfatwork.gui.util.GuiUtil;
import at.irian.jsfatwork.service.DishService;
import at.irian.jsfatwork.service.FinderService;
import at.irian.jsfatwork.service.ProviderService;
import org.apache.myfaces.extensions.cdi.core.api.config.view.ViewConfig;
import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewAccessScoped
public class ProviderBean implements Serializable {

    @Inject
    private ProviderService providerService;
    @Inject
    private FinderService finderService;
    @Inject
    private DishService dishService;
    @Inject
    private FacesContext facesContext;
    @Inject
    private NavigationResolver navigationResolver;

    @Min(value = 0)
    private Long id;

    private Provider provider;
    private Dish dish;
    private List<SelectItem> categoryItems;

    @PostConstruct
    public void init() {
        List<Category> categories = finderService.findAll(Category.class);
        categoryItems = new ArrayList<SelectItem>(categories.size());
        for (Category cat : categories) {
            categoryItems.add(new SelectItem(cat, cat.getName()));
        }
    }

    public String loadProvider() {
        if (id != null) {
            provider = providerService.findById(id);
            if (provider == null) {
                GuiUtil.addErrorMessage("error_non_existing_provider", id);
            }
        }
        return null;
    }

    public Provider getProvider() {
        return provider;
    }

    public Class<? extends ViewConfig> createProvider() {
        this.provider = providerService.createNew();
        return View.EditProvider.class;
    }

    public String cancel() {
        if (provider.isTransient()) {
            return navigationResolver.getNavigationOutcome(View.ProviderList.class).getOutcome();
        } else {
            return getShowProviderOutcome();
        }
    }

    public String saveProvider() {
        providerService.save(provider);
        id = provider.getId();
        return getShowProviderOutcome();
    }

    public Dish getDish() {
        return dish;
    }

    public Class<? extends ViewConfig> createDish() {
        this.dish = dishService.createNew();
        return View.EditDish.class;
    }

    public Class<? extends ViewConfig> editDish(Dish dish) {
        this.dish = dish;
        return View.EditDish.class;
    }

    public String saveDish() {
        dishService.save(provider, dish);
        this.provider = providerService.findById(this.provider.getId());
        this.dish = null;
        return getShowProviderOutcome();
    }

    public String cancelDish() {
        this.dish = null;
        return getShowProviderOutcome();
    }

    public void selectDish(Dish dish) {
        this.dish = dish;
    }

    public void deleteDish() {
        dishService.delete(dish);
        this.dish = null;
    }

    public List getCategoryItems() {
        return categoryItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String getShowProviderOutcome() {
        return navigationResolver.getNavigationOutcome(View.ShowProvider.class)
                .withIncludeViewParams(true)
                .getOutcome();
    }

}
