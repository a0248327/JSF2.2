package at.irian.jsfatwork.mygourmet;

import javax.faces.view.facelets.*;

public class InputSpinnerTagHandler extends ComponentHandler {

    private static final String ATTR_INC = "inc";

    private TagAttribute inc;

    public InputSpinnerTagHandler(ComponentConfig config) {
        super(config);
        this.inc = getRequiredAttribute(ATTR_INC);
    }

}
