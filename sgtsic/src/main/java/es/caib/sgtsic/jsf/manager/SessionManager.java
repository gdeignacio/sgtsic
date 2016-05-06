package es.caib.sgtsic.jsf.manager;


import es.caib.sgtsic.jsf.AbstractSessionManager;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "sessionManager")
@SessionScoped
public class SessionManager extends AbstractSessionManager implements Serializable {

    // CONSTRUCTOR
    public SessionManager() {
        super();
    }

    // INIT -----
    public void init() {
        inicio();
    }

}
