package home.pdm.servlet;

import home.pdm.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LOGGER.info(request.getParameter("name") + request.getParameter("category"));

        HttpSession session = request.getSession(true);

        List<Task> allTask;
        int count;
        if (session.getAttribute("task") == null) {
            LOGGER.info("new list");
            allTask = new ArrayList<>();
            count = -1;
        } else {
            LOGGER.info("load list");
            allTask = (List<Task>) session.getAttribute("task");
            count = allTask.size() - 1;
        }

        Task task = new Task();
        task.setName(request.getParameter("name"));
        task.setCategory(request.getParameter("category"));
        task.setId(++count);

        allTask.add(task);

        session.setAttribute("task", allTask);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}