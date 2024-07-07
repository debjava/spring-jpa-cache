package com.ddlab.rnd.repository;

import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ddlab.rnd.entity.Project;


@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

	@Cacheable(value = "project")
	Optional<Project> findById(Long id);
	
	@CacheEvict(cacheNames = "project", beforeInvocation = false, key = "#project.id")
	Project save(Project project);
}
