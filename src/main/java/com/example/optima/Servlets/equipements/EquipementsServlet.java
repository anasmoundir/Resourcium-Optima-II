package com.example.optima.Servlets.equipements;

import com.example.optima.Dao.BreakDownDao;
import com.example.optima.Dao.DeparetementDao;
import com.example.optima.Entities.BreakdownEntity;
import com.example.optima.Entities.DepartmentEntity;
import com.example.optima.Entities.EquipementEntity;
import com.example.optima.Services.BreakDownService;
import com.example.optima.Services.DeparetementService;
import com.example.optima.Services.EquipementsService;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.List;

@WebServlet("/equipements")
public class EquipementsServlet extends HttpServlet {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    private EquipementsService equipmentService = new EquipementsService();
    private DeparetementService deparetementService =new DeparetementService(entityManagerFactory);
    private BreakDownService breakDownService = new BreakDownService(entityManagerFactory);
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<DepartmentEntity> departments = deparetementService.AllDepartements();
        List<BreakdownEntity> breakdowns = breakDownService.AllBreakDown();
        List<EquipementEntity> equipmentList = equipmentService.getAllEquipment();
        System.out.println("here deparetemns" + departments);


        request.setAttribute("departments", departments);
        request.setAttribute("breakdowns", breakdowns);
        request.setAttribute("equipmentList", equipmentList);
        request.getRequestDispatcher("equipements.jsp").forward(request, response);
    }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            if (action != null) {
                if (action.equals("create")) {
                    String equipmentCode = request.getParameter("equipmentCode");
                    int availability = Integer.parseInt(request.getParameter("availability"));
                    int departmentId = Integer.parseInt(request.getParameter("departmentId"));
                    int BreakDown = Integer.parseInt(request.getParameter("breakdownId"));
                    EquipementEntity newEquipment = new EquipementEntity();
                    newEquipment.setEquipmentCode(equipmentCode);
                    newEquipment.setAvailability((byte) availability);
                    newEquipment.setIdDepartement(departmentId);
                    newEquipment.setIdBreakDown(BreakDown);
                    equipmentService.addEquipment(newEquipment,departmentId);

                } else if (action.equals("update")) {
                    int equipmentId = Integer.parseInt(request.getParameter("equipmentId"));
                    String equipmentCode = request.getParameter("equipmentCode");
                    int availability = Integer.parseInt(request.getParameter("availability"));
                    int departmentId = Integer.parseInt(request.getParameter("departmentId"));

                    EquipementEntity updatedEquipment = new EquipementEntity();
                    updatedEquipment.setIdEquipement(equipmentId);
                    updatedEquipment.setEquipmentCode(equipmentCode);
                    updatedEquipment.setAvailability((byte) availability);
                    updatedEquipment.setIdDepartement(departmentId);

                    equipmentService.updateEquipment(updatedEquipment);
                } else if (action.equals("delete")) {
                    int equipmentId = Integer.parseInt(request.getParameter("equipmentId"));
                    equipmentService.deleteEquipment(equipmentId);
                }
            }
            response.sendRedirect(request.getContextPath() + "/equipements");
        }}
