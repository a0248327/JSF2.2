package at.irian.jsfatwork.gui.page;

import at.irian.jsfatwork.domain.CreditCardType;
import at.irian.jsfatwork.domain.Customer;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class CustomerBean {
    private static final String CARD_A_NAME = "Card A";
    private static final String CARD_B_NAME = "Card B";

    private Customer customer = new Customer();
    private List<SelectItem> ccTypes;

    @PostConstruct
    private void init() {
        this.ccTypes = new ArrayList<SelectItem>();
        this.ccTypes.add(new SelectItem(CreditCardType.CARD_A, CARD_A_NAME));
        this.ccTypes.add(new SelectItem(CreditCardType.CARD_B, CARD_B_NAME));
    }

    public String save() {
        return "/showCustomer.xhtml";
    }

    public void useCreditCardChanged(ValueChangeEvent ev) {
        Boolean useCreditCard = (Boolean) ev.getNewValue();
        if (useCreditCard != null) {
            customer.setUseCreditCard(useCreditCard);
        }
        FacesContext.getCurrentInstance().renderResponse();
    }

    public String getSelectedCreditCardType() {
        String selectedCCType = null;
        if (customer.getCreditCardType() != null) {
            switch (customer.getCreditCardType()) {
                case CARD_A:
                    selectedCCType = CARD_A_NAME;
                    break;
                case CARD_B:
                    selectedCCType = CARD_B_NAME;
                    break;
                default:
                    break;
            }
        }
        return selectedCCType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<SelectItem> getCreditCardTypes() {
        return this.ccTypes;
    }

}
