package at.irian.jsfatwork.gui.page;

import at.irian.jsfatwork.domain.CreditCardType;
import at.irian.jsfatwork.domain.Customer;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class CustomerBean {
    private static final String CARD_A_NAME = "Card A";
    private static final String CARD_B_NAME = "Card B";

    private Customer customer = new Customer();
    private List<SelectItem> ccTypes;
    private UIInput creditCardTypeInput = null;

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

    public void postValidateCCType(ComponentSystemEvent event) throws AbortProcessingException {
        creditCardTypeInput = (UIInput)event.getComponent();
    }

    public void validateCreditNumber(FacesContext ctx, UIComponent component,
                                     Object value) throws ValidatorException {
        // Only validate credit card data if user specified to use it
        CreditCardType ccType = (CreditCardType) creditCardTypeInput.getValue();
        Boolean useCC = customer.getUseCreditCard();
        if (useCC != null && useCC && ccType != null) {
            // Check credit card number
            int length;
            if (ccType == CreditCardType.CARD_A) {
                length = 4;
            } else {
                length = 5;
            }
            String ccNumber = (String) value;
            if (ccNumber != null && !ccNumber.matches("\\d{" + length + "}")) {
                String msgText = MessageFormat.format(
                        "Credit card number must consist of {0} digits.", length);
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgText, null);
                throw new ValidatorException(msg);
            }
        }
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
