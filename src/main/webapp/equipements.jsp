    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Admin Dashboard</title>
        <!-- Add Tailwind CSS Link -->
        <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.15/dist/tailwind.min.css" rel="stylesheet">
    </head>
    <body class="bg-gray-100">
    <%@ include file="NavAdmin.jsp" %>
    <nav class="bg-blue-500 p-4 text-white">
        <h1 class="text-2xl font-semibold">Admin Dashboard</h1>
    </nav>

    <!-- Main Content Container -->
    <div class="container mx-auto p-4">
        <!-- Equipment Management Section -->
        <div class="my-8">
            <h2 class="text-2xl font-semibold">Equipment Management</h2>

            <!-- Equipment Table -->
            <table class="table-auto w-full">
                <thead>
                <tr>
                    <th class="px-4 py-2">ID</th>
                    <th class="px-4 py-2">Equipment Code</th>
                    <th class="px-4 py-2">Availability</th>
                    <th class="px-4 py-2">ID Breakdown</th>
                    <th class="px-4 py-2">ID Department</th>
                    <th class="px-4 py-2">Actions</th>
                </tr>
                </thead>
                <form action="equipements" method="post">
                    <!-- Input fields for creating new equipment -->
                    <input type="text" name="equipmentCode" placeholder="Equipment Code">
                    <input type="text" name="availability" placeholder="Availability">
                    <!-- Dropdowns for selecting department and breakdown -->
                    <select name="departmentId">
                        <c:forEach items="${departments}" var="department">
                            <option value="${department.idDepartement}">${department.name}</option>
                        </c:forEach>
                    </select>
                    <select name="breakdownId">
                        <c:forEach items="${breakdowns}" var="breakdown">
                            <option value="${breakdown.idBreakDown}">${breakdown.breakDownName}</option>
                        </c:forEach>
                    </select>
                    <input type="hidden" name="action" value="create">
                    <button type="submit">Create</button>
                </form>
                <tbody>
                <c:forEach items="${equipmentList}" var="equipment">
                    <tr>
                        <td class="px-4 py-2">${equipment.idEquipement}</td>
                        <td class="px-4 py-2">${equipment.equipmentCode}</td>
                        <td class="px-4 py-2">${equipment.availability}</td>
                        <td class="px-4 py-2">${equipment.idBreakDown}</td>
                        <td class="px-4 py-2">${equipment.idDepartement}</td>
                        <td class="px-4 py-2">

                            <form action="equipements" method="post"> <!-- Input fields for updating equipment -->
                                <input type="text" name="equipmentCode" value="${equipment.equipmentCode}">
                                <input type="text" name="availability" value="${equipment.availability}">
                                <!-- Dropdowns for department and breakdown -->
                                <select name="departmentId">
                                    <c:forEach items="${departments}" var="department">
                                        <option value="${department.idDepartement}">${department.name}</option>
                                    </c:forEach>
                                </select>
                                <select name="breakdownId">
                                    <c:forEach items="${breakdowns}" var="breakdown">
                                        <option value="${breakdown.idBreakDown}">${breakdown.breakDownName}</option>
                                    </c:forEach>
                                </select>
                                <input type="hidden" name="equipmentId" value="${equipment.idEquipement}">
                                <input type="hidden" name="action" value="update">
                                <button type="submit">Update</button>
                            </form>

                            <form action="equipements" method="post">
                                <%--@declare id="breakdownid"--%>
                                        <input type="hidden" name="equipmentId" value="${equipment.idEquipement}">
                                        <input type="hidden" name="action" value="delete">
                                        <button type="submit">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
    </body>
    </html>

