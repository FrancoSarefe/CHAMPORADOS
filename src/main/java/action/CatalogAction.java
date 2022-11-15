package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.ToyEntity;
import jdbc.JdbcConnectionManager;
import repository.ToyRepository;
import service.ToyCatalogService;

public class CatalogAction implements Action {
	
    private final ToyCatalogService toyCatalogService;
    private final JdbcConnectionManager jdbcConnectionManager;
    private final ToyRepository toyRepository;

    public CatalogAction() {
        jdbcConnectionManager = new JdbcConnectionManager();
        toyRepository = new ToyRepository(jdbcConnectionManager);
        toyCatalogService = new ToyCatalogService(toyRepository);
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final List<ToyEntity> toys = toyCatalogService.getToyCatalog();
        request.setAttribute("catalog", toys);
        return "/catalog.jsp";
    }
}
