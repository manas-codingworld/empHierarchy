package com.accen.app.resources;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.accen.app.datamodel.Employee;
import com.accen.app.services.interfaces.EmployeeService;

/**
 * 
 * @author manasranjan
 * endpoints for the employee service
 *
 */
@Named
@Path("/employee")
public class EmployeeResource {

	@Inject
	EmployeeService employeeBusinessService;

	/**
	 * service to insert employee
	 * @param employee
	 * @return inserted employee with generated id
	 */
	@POST
	@Path("/insert")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response insertEmployee(Employee emp) {
		System.out.println("here now>>>>>");
		Employee result = employeeBusinessService.insert(emp);

		return Response.ok(result).build();
	}

	/**
	 * 
	 * @param emp
	 * @return
	 */
	@GET
	@Path("/hierarchy")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response printHierarchy(Employee emp) {
		List<Employee> empList = employeeBusinessService.getHierarchy(emp);
		return Response.ok(empList).build();
	}

	/**
	 * 
	 * @return list of top 10 salaried employee details
	 */
	@GET
	@Path("/topSal")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getTopSal() {
		List<Employee> empList = employeeBusinessService.getTop();
		return Response.ok(empList).build();
	}

	/**
	 * service to delete employee and update the manager ID for the employees accordingly
	 * @param employee object to be deleted
	 * @return 
	 */
	@DELETE
	@Path("/delete")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteEmployee(Employee emp) {
		employeeBusinessService.delete(emp.getId());
		return Response.ok().build();
	}

}
