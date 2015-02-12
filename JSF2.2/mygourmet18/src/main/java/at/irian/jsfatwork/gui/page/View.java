package at.irian.jsfatwork.gui.page;

import org.apache.myfaces.extensions.cdi.core.api.config.view.ViewConfig;
import org.apache.myfaces.extensions.cdi.jsf.api.config.view.Page;
import org.apache.myfaces.extensions.cdi.jsf.api.config.view.PageBean;

/**
 * @author Michael Kurz
 */
@Page(basePath = "")
public interface View extends ViewConfig {

    @Page
    @PageBean(AddCustomerBean.class)
    public class AddCustomer1 implements View {
    }

    @Page
    @PageBean(AddCustomerBean.class)
    public class AddCustomer2 implements View {
    }

    @Page
    @PageBean(CustomerListBean.class)
    public class CustomerList implements View {
    }

    @Page
    @PageBean(CustomerBean.class)
    public class ShowCustomer implements View {
    }

    @Page
    @PageBean(CustomerBean.class)
    public class EditAddress implements View {
    }

    @Page(navigation = Page.NavigationMode.REDIRECT)
    @PageBean(ProviderBean.class)
    public class ShowProvider implements View {
    }

    @Page(navigation = Page.NavigationMode.REDIRECT)
    @PageBean(ProviderBean.class)
    public class EditProvider implements View {
    }

}
