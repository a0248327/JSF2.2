package at.irian.jsfatwork.gui.page;

import at.irian.jsfatwork.domain.*;
import at.irian.jsfatwork.gui.util.GuiUtil;
import at.irian.jsfatwork.service.CustomerService;
import at.irian.jsfatwork.service.ProviderService;
import org.apache.myfaces.extensions.cdi.core.api.config.view.ViewConfig;
import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.Conversation;
import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ConversationScoped;
import org.apache.myfaces.extensions.cdi.jsf.api.config.view.PreRenderView;

import javax.enterprise.inject.Instance;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ConversationScoped
public class OrderBean implements Serializable {

    @Inject
    private CustomerService customerService;
    @Inject
    private ProviderService providerService;
    @Inject
    private Conversation conversation;
    @Inject
    private Instance<CustomerBean> customerBean;

    private Customer customer;
    private Order order;
    private Provider provider;
    private List<Provider> providers;
    private List<SelectableDish> dishes;

    @PreRenderView
    public void preRenderView() {
        providers = providerService.findAll();
    }

    public Class<? extends ViewConfig> start(long customerId) {
        customer = customerService.findById(customerId);
        order = customerService.createOrder();
        return View.OrderProvider.class;
    }

    public Class<? extends ViewConfig> gotoDishes() {
        dishes = initSelectableDishes();
        order.setProvider(provider);
        return View.OrderDishes.class;
    }

    public Class<? extends ViewConfig> gotoFinish() {
        if (!createOrderItems()) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            FacesMessage msg = GuiUtil.getFacesMessage(ctx, FacesMessage.SEVERITY_ERROR, "error_no_dishes");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        }
        dishes = initSelectableDishes();
        return View.OrderFinish.class;
    }

    private boolean createOrderItems() {
        boolean containsItem = false;
        for (SelectableDish dish : dishes) {
            if (dish.isSelected() && dish.getAmount() != null) {
                OrderItem item = new OrderItem();
                item.setDish(dish.getDish());
                item.setAmount(dish.getAmount());
                order.addOrderItem(item);
                containsItem = true;
            }
        }
        return containsItem;
    }

    public Class<? extends ViewConfig> finish() {
        customerService.saveOrder(customer, order);
        conversation.close();
        return customerBean.get().showCustomer(customer.getId());
    }

    public Class<? extends ViewConfig> cancel() {
        conversation.close();
        return customerBean.get().showCustomer(customer.getId());
    }

    public Order getOrder() {
        return order;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public List<SelectableDish> getDishes() {
        return dishes;
    }

    private List<SelectableDish> initSelectableDishes() {
        List<SelectableDish> list = null;
        if (provider != null && this.dishes == null) {
            list = new ArrayList<SelectableDish>();
            for (Dish dish : provider.getDishes()) {
                list.add(new SelectableDish(dish));
            }
        }
        return list;
    }

}
