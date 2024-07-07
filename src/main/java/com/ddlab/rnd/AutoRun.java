package com.ddlab.rnd;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.ddlab.rnd.entity.Address;
import com.ddlab.rnd.entity.Employee;
import com.ddlab.rnd.entity.Project;
import com.ddlab.rnd.service.ProjectService;

@Component
public class AutoRun {

	@Autowired
	private ProjectService projService;

	private void saveProject1() {
		Address adrs1 = new Address();
		adrs1.setCity("Chennai");

		Address adrs2 = new Address();
		adrs2.setCity("Saint Petersburg");

		Employee emp1 = new Employee();
		emp1.setName("Ravi Chopda");
		emp1.setAdrs(adrs1);

		Employee emp2 = new Employee();
		emp2.setName("Satiago Millet");
		emp2.setAdrs(adrs2);

		List<Employee> empList = List.of(emp1, emp2);

		Project p1 = new Project();
		p1.setName("Horamavu");
		p1.setEmpList(empList);

		projService.save(p1);
	}

	private void saveProject2() {
		Address adrs1 = new Address();
		adrs1.setCity("Bangalore");

		Address adrs2 = new Address();
		adrs2.setCity("Moscow");

		Employee emp1 = new Employee();
		emp1.setName("John Abraham");
		emp1.setAdrs(adrs1);

		Employee emp2 = new Employee();
		emp2.setName("Shyam Sunder");
		emp2.setAdrs(adrs2);

		List<Employee> empList = List.of(emp1, emp2);

		Project p1 = new Project();
		p1.setName("Dumalica");
		p1.setEmpList(empList);

		projService.save(p1);
	}

	private void getProjectDetails(Long id) {
		Project project = projService.getById(id);
		System.out.println("Project: " + project);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void run() {
		System.out.println("--------- Application Running -----------");
		saveProject1();
		saveProject2();
		sleep(10);
		getProjectDetails(Long.valueOf(2));
		getProjectDetails(Long.valueOf(1));
		System.out.println("Waiting for 20 seconds ...");
		sleep(20);
		getProjectDetails(Long.valueOf(1));
		getProjectDetails(Long.valueOf(2));
	}

	private void sleep(long time) {
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
