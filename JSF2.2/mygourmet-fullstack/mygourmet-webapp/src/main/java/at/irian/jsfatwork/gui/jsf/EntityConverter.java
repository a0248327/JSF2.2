package at.irian.jsfatwork.gui.jsf;

import at.irian.jsfatwork.domain.BaseEntity;
import at.irian.jsfatwork.service.FinderService;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.io.Serializable;

public class EntityConverter<T extends BaseEntity> implements Converter, Serializable {
    private static final long serialVersionUID = -1176470402158735L;

    private FinderService finderService;
    private Class<T> classToLoad;

    public EntityConverter(FinderService finderService, Class<T> classToLoad) {
        this.classToLoad = classToLoad;
        this.finderService = finderService;
    }

    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
        if (value == null || value.length() == 0) {
            return null;
        }
        long id = new Long(value);
        return finderService.find(classToLoad, id);
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        return ((BaseEntity)value).getId().toString();
    }

}
