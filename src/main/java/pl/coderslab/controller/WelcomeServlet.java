package pl.coderslab.controller;

import pl.coderslab.model.Solution;
import pl.coderslab.util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class WelcomeServlet extends HttpServlet {
    private int solutionLimit = 10;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            Solution[] solutions = Solution.loadAllWithLimit(DbUtil.getConn(), solutionLimit);
            request.setAttribute("solutions", solutions);
            getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error while fetching solutions", e);
        }
    }


    public void init() {
        String solutionLimitInitParam = getInitParameter("number-soltions");
        if (solutionLimitInitParam != null) {
            solutionLimit = Integer.valueOf(solutionLimitInitParam);
        }
    }
}
