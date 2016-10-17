package si.util;

import javax.faces.context.FacesContext;

/**
 * Created by mateus on 17/10/16.
 */

public class FacesUtil {

    public static String getParameter(String param){
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(param);
    }
}
