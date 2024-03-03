package infrastructure.adapters;

import application.ports.out.FeaturePersistencePort;
import domain.entities.Feature;
import javax.persistence.EntityManager;
import java.util.Optional;

public class FeaturePersistenceAdapter implements FeaturePersistencePort {

    private final EntityManager entityManager;

    public FeaturePersistenceAdapter(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Feature saveFeature(Feature feature) {
        entityManager.persist(feature);
        return feature;
    }

    @Override
    public void deleteFeature(Long id) {
        Feature feature = entityManager.find(Feature.class, id);
        if (feature != null) {
            entityManager.remove(feature);
        }
    }

    @Override
    public Optional<Feature> findFeatureById(Long id) {
        Feature feature = entityManager.find(Feature.class, id);
        return Optional.ofNullable(feature);
    }
}