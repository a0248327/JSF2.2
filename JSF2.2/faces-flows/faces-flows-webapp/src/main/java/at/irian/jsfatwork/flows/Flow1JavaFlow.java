package at.irian.jsfatwork.flows;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;
import java.io.Serializable;

public class Flow1JavaFlow implements Serializable {

    @Produces @FlowDefinition
    public Flow buildFlow(
            @FlowBuilderParameter FlowBuilder flowBuilder) {
        flowBuilder.id("", "flow1-java");
        flowBuilder.viewNode("start", "/flow1-java/flow1.xhtml")
                .markAsStartNode();
        flowBuilder.viewNode("final", "/flow1-java/page2.xhtml");
        flowBuilder.returnNode("return").fromOutcome("/index");
        flowBuilder.initializer("#{flow1JavaBean.initializeFlow}");
        flowBuilder.finalizer("#{flow1JavaBean.finalizeFlow}");
        return flowBuilder.getFlow();
    }

}
