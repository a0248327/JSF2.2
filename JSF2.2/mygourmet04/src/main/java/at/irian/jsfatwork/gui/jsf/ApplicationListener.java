package at.irian.jsfatwork.gui.jsf;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.faces.application.Application;
import javax.faces.event.PostConstructApplicationEvent;
import javax.faces.event.PreDestroyApplicationEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

/**
 * @author Michael Kurz
 */
public class ApplicationListener implements SystemEventListener {
    private static Log log = LogFactory.getLog(ApplicationListener.class);

    @Override
    public void processEvent(SystemEvent event) {
        if (event instanceof PostConstructApplicationEvent) {
            log.debug("application startup ");
        } else if (event instanceof PreDestroyApplicationEvent) {
            log.debug("application shutdown");
        }
    }

    @Override
    public boolean isListenerForSource(Object source) {
        return source instanceof Application;
    }

}
