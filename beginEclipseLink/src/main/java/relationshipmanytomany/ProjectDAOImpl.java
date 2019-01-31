package relationshipmanytomany;

import javax.persistence.EntityManager;

public class ProjectDAOImpl implements ProjectDAO {

	private EntityManager entityManager;

	public ProjectDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Project insertProject(String name) {

		Project project = new Project(name);
		entityManager.persist(project);

		return project;
	}

}
