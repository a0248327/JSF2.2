package at.irian.jsfatwork.gui.jsf.navigation;

import java.util.LinkedHashMap;
import java.util.Map;

public class NavigationOutcome {
    private String viewId;
    private boolean redirect;
    private boolean includeViewParams;
    private Map<String, String> parameters;

    public NavigationOutcome(String viewId, boolean redirect) {
        this.viewId = viewId;
        this.redirect = redirect;
        this.parameters = new LinkedHashMap<String, String>();
    }

    public NavigationOutcome withParameter(String name, String value) {
        parameters.put(name, value);
        return this;
    }

    public String getOutcome() {
        StringBuilder outcome = new StringBuilder();
        boolean parameterAppended = false;
        outcome.append(viewId);
        if (redirect) {
            outcome.append("?faces-redirect=true");
            parameterAppended = true;
        }
        if (includeViewParams) {
            if (parameterAppended) {
                outcome.append("&");
            } else {
                outcome.append("?");
                parameterAppended = true;
            }
            outcome.append("includeViewParams=true");
        }
        if (parameters != null && parameters.size() > 0) {
            for (Map.Entry<String, String> parameter : parameters.entrySet()) {
                if (parameterAppended) {
                    outcome.append("&");
                } else {
                    outcome.append("?");
                    parameterAppended = true;
                }
                outcome.append(parameter.getKey());
                outcome.append("=");
                outcome.append(parameter.getValue());
            }
        }
        return outcome.toString();
    }

    public NavigationOutcome withRedirect(boolean redirect) {
        this.redirect = redirect;
        return this;
    }

    public NavigationOutcome withIncludeViewParams(boolean includeViewParams) {
        this.includeViewParams = includeViewParams;
        return this;
    }

}
