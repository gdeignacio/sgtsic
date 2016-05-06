package es.caib.sgtsic.jsf.manager;

import com.sun.faces.application.ActionListenerImpl;

import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class ExceptionManager extends ActionListenerImpl implements ActionListener {

	public void handleBeanAction(ActionEvent event) {
		try {
			super.processAction(event);
		}
		catch (Exception exception){
			FacesContext facesContext = FacesContext.getCurrentInstance();
			Application application = facesContext.getApplication();
			NavigationHandler navigationHandler =  application.getNavigationHandler();
			navigationHandler.handleNavigation(facesContext, null, "saltaExcepcion");
			facesContext.renderResponse();
		}
	}

}

