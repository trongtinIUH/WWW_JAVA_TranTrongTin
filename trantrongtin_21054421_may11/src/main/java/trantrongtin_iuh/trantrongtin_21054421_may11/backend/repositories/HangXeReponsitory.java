package trantrongtin_iuh.trantrongtin_21054421_may11.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class HangXeReponsitory {
    @PersistenceContext(unitName = "GK_Xe")
    private EntityManager entityManager;
}
