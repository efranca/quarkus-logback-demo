package io.foo.now.domain.service;

import java.util.List;

import io.foo.now.domain.model.Project;

public interface IProjectService {

    List<Project> get();

    Project get(Long id);

    boolean delete(Long id);

    Project update(Long id, Project entity);

    Project create(Project entity);
}