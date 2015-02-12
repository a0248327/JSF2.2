package at.irian.jsfatwork.flows;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;
import java.io.Serializable;

public class LoginJavaFlow implements Serializable {

    @Produces @FlowDefinition
    public Flow buildFlow(@FlowBuilderParameter FlowBuilder flowBuilder) {
        flowBuilder.id("", "login-java");
        flowBuilder.viewNode("start", "/login-java/login-java.xhtml")
                .markAsStartNode();
        flowBuilder.viewNode("success", "/login-java/success.xhtml");
        flowBuilder.viewNode("error", "/login-java/error.xhtml");
        flowBuilder.flowCallNode("forgotPassword")
                .flowReference("", "forgotPassword")
                .outboundParameter("username", "#{loginJavaBean.username}");
        flowBuilder.navigationCase()
                .fromViewId("*")
                .fromOutcome("forgotPassword-return")
                .toViewId("/login-java/login-java.xhtml");
        flowBuilder.returnNode("login-return").fromOutcome("/index");
        return flowBuilder.getFlow();
    }

}
