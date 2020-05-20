package backend;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Response
 */
@WebServlet("/Response")
public class Response extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Response() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletRequest servletRequest = (ServletRequest)request;
		//get the user input 
		String gender = servletRequest.getParameter("gender"); 
		String weight_s = servletRequest.getParameter("weight");
		String height_s = servletRequest.getParameter("height");
		String age_s = servletRequest.getParameter("age");
		String activity = servletRequest.getParameter("activity");
		
		//create print writer instance
		PrintWriter out = response.getWriter();
		
		//check if user has been filling all the information, if not print a warning message and return to the page
		if (gender.isEmpty() || weight_s.isEmpty() || height_s.isEmpty() || age_s.isEmpty() || activity.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			out.println("<font color = red>Please fill all the information</font>");
			rd.include(request, response);
		} else {   // if all the information is flled:

			// convert weight and height from string to double, convert age to int
			double weight = Double.valueOf(servletRequest.getParameter("weight"));
			double height = Double.valueOf(servletRequest.getParameter("height"));
			int age = Integer.valueOf(servletRequest.getParameter("age"));
			
			//calculate the bmr by using formula for men and women
			double bmr, calorie_maintenance;
			double act_rate = 1;
			if (gender.equals("Men")) {
				bmr = 66 + (13.7 * weight) + (5 * height) - (6.8 * age);
			} else {
				bmr = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * age);
			}
			
			//set activity rate for different activity level
			if (activity.equals("sedentary")) {
				act_rate = 1.2;
			} else if (activity.equals("lightly active")) {
				act_rate = 1.375;
			} else if (activity.equals("moderately")) {
				act_rate = 1.55;
			} else if (activity.equals("very active")) {
				act_rate = 1.725;
			} else if (activity.equals("extra active")) {
				act_rate = 1.9;
			}
			//multiply bmr by activity rate to get calorie
			calorie_maintenance = bmr * act_rate;
			
			//print out calculation result
			response.setContentType("text/html");
			out.println("your bmr: " + "<p>" + bmr + "</p>");
			out.println("your calorie maintenance: " + "<p>" + calorie_maintenance + "</p>");
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
