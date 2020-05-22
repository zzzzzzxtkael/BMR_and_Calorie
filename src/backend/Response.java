package backend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.User;

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
		
		boolean success = true;
		
		//check if user has been filling all the information, if not print a warning message and return to the page
		if (gender == null || weight_s == null  || height_s == null || age_s == null || activity == null) {
			request.setAttribute("msg","Please fill in all the information");
			success = false;
			
			
			//RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			//rd.include(request, response);
		} else {   // if all the information is flled:
			User temp = new User();
			// convert weight and height from string to double, convert age to int
			temp.setWeight(Double.valueOf(weight_s));
			temp.setHeight(Double.valueOf(height_s));
			temp.setAge(Integer.valueOf(age_s));
			temp.setGender(gender);
			//calculate the bmr by using formula for men and women
			double bmr, calorie_maintenance;
			double act_rate = 1;
			if (gender.equals("Men")) {
				bmr = 66 + (13.7 * temp.getWeight()) + (5 * temp.getHeight()) - (6.8 * temp.getAge());
			} else {
				bmr = 655 + (9.6 * temp.getWeight()) + (1.8 * temp.getHeight()) - (4.7 * temp.getAge());
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
			request.setAttribute("msg","");
			request.setAttribute("bmr",bmr);
			request.setAttribute("calorie",calorie_maintenance);
			
		}
		request.setAttribute("success", success);
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
