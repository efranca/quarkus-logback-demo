package io.foo.now.domain.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.foo.now.domain.model.Project;
import io.foo.now.infrastructure.ProjectRepository;

@ApplicationScoped
public class ProjectService implements IProjectService {
    @Inject
    ProjectRepository repository;

    public List<Project> get() {
        return repository.get();
    }

    public Project get(Long id) {
        return repository.get(id);
    }

    public boolean delete(Long id) {
        return repository.delete(id);
    }

    public Project update(Long id, Project entity) {
        return repository.update(id, entity);
    }

    public Project create(Project entity) {
        return repository.create(entity);
    }
}
