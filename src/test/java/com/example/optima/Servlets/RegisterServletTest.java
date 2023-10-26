package com.example.optima.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterServletTest {

    @Test
    void doGet() {
        // Create instances of your servlet, request, and response
        RegisterServlet registerServlet = new RegisterServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);

        try {
            // Mock HttpServletRequest behavior
            when(request.getRequestDispatcher("Register.jsp")).thenReturn(requestDispatcher);

            // Call the servlet's doGet method
            registerServlet.doGet(request, response);

            // Verify that getRequestDispatcher and forward were called as expected
            verify(request).getRequestDispatcher("Register.jsp");
            verify(requestDispatcher).forward(request, response);
        } catch (Exception e) {
            fail("An exception occurred: " + e.getMessage());
        }
    }

    @Test
    void doPost_successfulRegistration() {
        // Create instances of your servlet, request, and response
        RegisterServlet registerServlet = new RegisterServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        try {
            // Mock HttpServletRequest behavior to simulate a successful registration
            when(request.getParameter("email")).thenReturn("user@example.com");
            when(request.getParameter("password")).thenReturn("password");
            when(request.getParameter("repeat_password")).thenReturn("password");
            when(request.getParameter("phoneNumber")).thenReturn("123456789");
            when(request.getParameter("gender")).thenReturn("1");

            // Call the servlet's doPost method
            registerServlet.doPost(request, response);

            // Add your assertions here to check the behavior of your servlet after a successful registration
            // For example, verify that the response was redirected to the expected page
            // Use verify(response).sendRedirect(...) to check the redirection behavior

        } catch (Exception e) {
            fail("An exception occurred: " + e.getMessage());
        }
    }

    @Test
    void doPost_failedRegistration() {
        // Create instances of your servlet, request, and response
        RegisterServlet registerServlet = new RegisterServlet();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        try {
            // Mock HttpServletRequest behavior to simulate a failed registration (e.g., mismatched passwords)
            when(request.getParameter("email")).thenReturn("user@example.com");
            when(request.getParameter("password")).thenReturn("password");
            when(request.getParameter("repeat_password")).thenReturn("different_password");
            when(request.getParameter("phoneNumber")).thenReturn("123456789");
            when(request.getParameter("gender")).thenReturn("1");

            // Call the servlet's doPost method
            registerServlet.doPost(request, response);

            // Add your assertions here to check the behavior of your servlet after a failed registration
            // For example, verify that the response was redirected to the error page

        } catch (Exception e) {
            fail("An exception occurred: " + e.getMessage());
        }
    }
}