package at.irian.jsfatwork.gui.jsf;

import javax.faces.component.behavior.ClientBehaviorBase;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.component.behavior.FacesBehavior;
import javax.faces.component.UIComponent;

@FacesBehavior("at.irian.ClientLongValidator")
public class ClientLongValidator extends ClientBehaviorBase {

    @Override
    public String getScript(ClientBehaviorContext behaviorContext) {
        UIComponent comp = behaviorContext.getComponent();
        String clientId = comp.getClientId();
        return "var input = document.getElementById('" + clientId + "');if (input.value > 3) alert('> 3');";
    }
}
