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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UpdateServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LOGGER.info(request.getParameter("name") + request.getParameter("category"));

        HttpSession session = request.getSession(true);

        Object object = session.getAttribute("task");

        PrintWriter out = response.getWriter();

        if (object instanceof List) {
            List<Task> allTask = (ArrayList<Task>) object;

            String listTask[] = request.getParameterValues("complete");
            if (listTask != null && listTask.length != 0) {
                for (int i = 0; i < listTask.length; i++) {
                    int index = Integer.parseInt(listTask[i]);
                    allTask.get(index).setStyleClass("removeTask");
                    allTask.set(index, allTask.get(index));
                }
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }
}