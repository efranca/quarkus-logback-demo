package io.foo.now.domain.model;

import java.util.List;

import io.quarkus.panache.common.Sort;

public interface IProjectRepository  {
    Project create(Project entity);

    Project update(Long id, Project entityIn);

    boolean delete(Long id);

    List<Project> get();

    List<Project> get(Sort sort);

    Project get(Long id);
}
