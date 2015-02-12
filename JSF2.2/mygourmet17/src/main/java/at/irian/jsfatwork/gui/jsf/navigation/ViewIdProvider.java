package at.irian.jsfatwork.gui.jsf.navigation;

import at.irian.jsfatwork.gui.page.View;
import org.apache.myfaces.extensions.cdi.jsf.api.config.view.ViewConfigResolver;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Michael Kurz
 */
@Named
@ApplicationScoped
public class ViewIdProvider {

    @Inject
    private ViewConfigResolver viewConfigResolver;

    public String getAddCustomer() {
        return viewConfigResolver.getViewConfigDescriptor(View.AddCustomer1.class).getViewId();
    }

    public String getShowProvider() {
        return viewConfigResolver.getViewConfigDescriptor(View.ShowProvider.class).getViewId();
    }

    public String getEditProvider() {
        return viewConfigResolver.getViewConfigDescriptor(View.EditProvider.class).getViewId();
    }

}
