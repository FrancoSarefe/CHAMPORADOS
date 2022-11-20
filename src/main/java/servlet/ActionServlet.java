package servlet;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import action.Action;

@WebServlet(urlPatterns = "*.do", loadOnStartup = 1)

public class ActionServlet extends HttpServlet {
	
    private static final long serialVersionUID = -4989836977779120669L;
    private static final Logger logger = LogManager.getLogger(ActionServlet.class);

    private ResourceBundle actionConfig;

    @Override
    public void init() throws ServletException {
        actionConfig = ResourceBundle.getBundle("action");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.execute(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.execute(request, response);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        
            final String servletPath = request.getServletPath();
            final String actionClass = actionConfig.getString(servletPath.substring(1));

            if (actionClass == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, String.format("Action class not found: %s", actionClass));
            
            } else {
                final Action action = (Action)Class.forName(actionClass).newInstance();
                final String viewPath = action.execute(request, response);
                RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
                dispatcher.forward(request, response);
            }

            logger.info("action=execute, servlet_paht={}", servletPath);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to process request.");
        }

    }
}
