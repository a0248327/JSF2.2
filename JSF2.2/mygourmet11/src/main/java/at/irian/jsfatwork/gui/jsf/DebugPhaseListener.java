package at.irian.jsfatwork.gui.jsf;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * PhaseListener that logs a short message before and after every phase.
 * 
 * @author Michael Kurz
 */
public class DebugPhaseListener implements PhaseListener {
    private static final long serialVersionUID = 28697126271609506L;
    private static Log log = LogFactory.getLog(DebugPhaseListener.class);

    public void afterPhase(PhaseEvent event) {
		log.debug("After phase: " + event.getPhaseId());
	}

	public void beforePhase(PhaseEvent event) {
		log.debug("Before phase: " + event.getPhaseId());
	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
