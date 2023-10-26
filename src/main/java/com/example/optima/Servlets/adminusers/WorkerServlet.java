package com.example.optima.Servlets.adminusers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.optima.Entities.WorkerEntity;
import com.example.optima.Services.WorkerService;

import java.io.IOException;
import java.util.List;

@WebServlet("/worker")
public class WorkerServlet extends HttpServlet {
    private WorkerService workerService;
    public WorkerServlet() {
        super();
        workerService = new WorkerService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("edit")) {
            int idWorker = Integer.parseInt(request.getParameter("idWorker"));
            WorkerEntity worker = workerService.getWorkerById(idWorker);
            request.setAttribute("editWorker", worker);
        }

        List<WorkerEntity> workerList = workerService.getAllWorkers();
        request.setAttribute("workerList", workerList);
        request.getRequestDispatcher("/worker.jsp").forward(request, response);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            if (action.equals("create")) {
                byte availability = Byte.parseByte(request.getParameter("availability"));
                int maxHours = Integer.parseInt(request.getParameter("maxHours"));

                WorkerEntity newWorker = new WorkerEntity();
                newWorker.setAvailability(availability);
                newWorker.setMaxHours(maxHours);

                workerService.addWorker(newWorker);

            } else if (action.equals("update")) {
                int idWorker = Integer.parseInt(request.getParameter("idWorker"));
                byte availability = Byte.parseByte(request.getParameter("availability"));
                int maxHours = Integer.parseInt(request.getParameter("maxHours"));
                // Retrieve other updated worker properties

                WorkerEntity updatedWorker = new WorkerEntity();
                updatedWorker.setIdWorker(idWorker);
                updatedWorker.setAvailability(availability);
                updatedWorker.setMaxHours(maxHours);
                // Set other updated worker properties

                workerService.updateWorker(updatedWorker);

            } else if (action.equals("delete")) {
                int idWorker = Integer.parseInt(request.getParameter("idWorker"));
                workerService.deleteWorker(idWorker);
            }
        }

        // Redirect back to the worker list page
        response.sendRedirect(request.getContextPath() + "/workerManagement");
    }
}