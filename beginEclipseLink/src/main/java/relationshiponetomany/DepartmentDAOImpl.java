package relationshiponetomany;

import javax.persistence.EntityManager;

public class DepartmentDAOImpl implements DepartmentDAO {

	private EntityManager entityManager;

	public DepartmentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Department2 insertDepartment(String name) {

		Department2 department = new Department2(name);
		entityManager.persist(department);

		return department;
	}

}
