package at.irian.jsfatwork.flows;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@FlowScoped("flow1-java")
public class Flow1JavaBean implements Serializable {
    private static Log log = LogFactory.getLog(Flow1JavaBean.class);

    public void initializeFlow() {
        log.debug("Flow1 Java Initialized");
    }

    public void finalizeFlow() {
        log.debug("Flow1 Java Finalized");
    }
}
