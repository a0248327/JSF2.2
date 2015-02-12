package at.irian.jsfatwork.gui.page;

import at.irian.jsfatwork.domain.CreditCardType;
import at.irian.jsfatwork.domain.Customer;
import at.irian.jsfatwork.gui.util.GuiUtil;

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
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class CustomerBean {
	private Customer customer = new Customer();
	private List<SelectItem> ccTypes;
    private UIInput creditCardTypeInput = null;

    @PostConstruct
    private void init() {
        this.ccTypes = new ArrayList<SelectItem>();
        this.ccTypes.add(new SelectItem(CreditCardType.CARD_A, getCCTypeLabel(CreditCardType.CARD_A)));
        this.ccTypes.add(new SelectItem(CreditCardType.CARD_B, getCCTypeLabel(CreditCardType.CARD_B)));
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
			selectedCCType = getCCTypeLabel(customer.getCreditCardType());
        }
        return selectedCCType;
    }

    public void postValidateCCType(ComponentSystemEvent event) throws AbortProcessingException {
        creditCardTypeInput = (UIInput)event.getComponent();
    }

    public void validateCreditNumber(FacesContext ctx, UIComponent component,
            Object value) throws ValidatorException {
        // Only validate credit card data if user specified to use it
        CreditCardType ccType = (CreditCardType)creditCardTypeInput.getValue();
        Boolean useCC = customer.getUseCreditCard();
        if (useCC != null && useCC && ccType != null) {
            // Check credit card number
            int length;
            if (ccType == CreditCardType.CARD_A) {
                length = 4;
            } else {
                length = 5;
            }
            String ccNumber = (String)value;
            if (ccNumber != null && !ccNumber.matches("\\d{" + length + "}")) {
                FacesMessage msg = GuiUtil.getFacesMessage(
                        ctx, FacesMessage.SEVERITY_ERROR, "validateCreditCardNumber.NUMBER", length);
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

    private String getCCTypeLabel(CreditCardType type) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        String key = "credit_card_type_" + type.toString();
        return GuiUtil.getResourceText(ctx, "msgs", key);
    }

}
