package at.irian.jsfatwork.gui.jsf.navigation;

import org.apache.myfaces.extensions.cdi.core.api.config.view.ViewConfig;
import org.apache.myfaces.extensions.cdi.jsf.api.config.view.Page;
import org.apache.myfaces.extensions.cdi.jsf.api.config.view.ViewConfigDescriptor;
import org.apache.myfaces.extensions.cdi.jsf.api.config.view.ViewConfigResolver;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 */
@ApplicationScoped
public class NavigationResolver {

    @Inject
    private ViewConfigResolver viewConfigResolver;

    public NavigationOutcome getNavigationOutcome(Class<? extends ViewConfig> viewConfig) {
        // Get the view config descriptor
        ViewConfigDescriptor viewConfigDescriptor = viewConfigResolver.getViewConfigDescriptor(viewConfig);
        String viewId = viewConfigDescriptor.getViewId();
        boolean redirect = Page.NavigationMode.REDIRECT == viewConfigDescriptor.getNavigationMode();
        return new NavigationOutcome(viewId, redirect);
    }

}
