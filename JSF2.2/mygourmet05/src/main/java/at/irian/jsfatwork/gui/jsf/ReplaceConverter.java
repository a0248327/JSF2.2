package at.irian.jsfatwork.gui.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("at.irian.ReplaceConverter")
public class ReplaceConverter implements Converter {
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) throws ConverterException {
        if (value == null) {
            return null;
        }
        return value.replaceAll("\\s+", "_");
    }

    public String getAsString(FacesContext ctx, UIComponent component, Object value) throws ConverterException {
        if (value == null) {
            return null;
        }
        return value.toString();
    }
}
