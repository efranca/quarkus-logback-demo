package io.foo.now.infrastructure;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.foo.now.domain.model.IProjectRepository;
import io.foo.now.domain.model.Project;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class ProjectRepository implements IProjectRepository, PanacheRepository<Project> {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectRepository.class);

    @Transactional
    public Project create(Project entity) {
        persist(entity);
        return entity;
    }

    @Transactional
    public Project update(Long id, Project entityIn) {
        Project entity = get(id);
        // TODO: update object
        persist(entity);
        return entity;
    }

    @Transactional
    public boolean delete(Long id) {
        Project entity = get(id);
        if (entity == null) {
            LOG.error("Error deleting ID: " + id);
            return false;
        }
        persist(entity);
        return true;
    }

    public List<Project> get() {
        return get(Sort.by("id").descending());
    }

    public List<Project> get(Sort sort) {
        return findAll(sort).list();
    }

    public Project get(Long id) {
        return find("id = ?1", id).firstResult();
    }
}
