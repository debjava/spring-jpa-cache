package com.ddlab.rnd.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddlab.rnd.entity.Project;
import com.ddlab.rnd.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository projRepo;

	@Override
	public Project save(Project project) {
		return projRepo.save(project);
	}

	@Override
	public Project getById(Long id) {
		Optional<Project> projOpt = projRepo.findById(id);
		return projOpt.get();
	}

}
