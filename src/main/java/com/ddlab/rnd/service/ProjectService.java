package com.ddlab.rnd.service;

import com.ddlab.rnd.entity.Project;

public interface ProjectService {

	Project save(Project project);

	Project getById(Long id);
}
