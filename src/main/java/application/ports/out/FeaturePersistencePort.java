package application.ports.out;

import domain.entities.Feature;
import java.util.Optional;

/**
 * This interface defines the output port for persisting data related to the feature.
 * It abstracts the details of data storage, which are implemented by an adapter in the infrastructure layer.
 */
public interface FeaturePersistencePort {

    /**
     * Persists a given Feature entity and returns the persisted entity.
     *
     * @param feature the feature entity to persist
     * @return the persisted feature entity
     */
    Feature saveFeature(Feature feature);

    /**
     * Deletes the Feature entity with the specified id.
     *
     * @param id the id of the feature to delete
     */
    void deleteFeature(Long id);

    /**
     * Retrieves a Feature entity by its id if it exists.
     *
     * @param id the id of the feature to retrieve
     * @return an Optional containing the found feature or an empty Optional if not found
     */
    Optional<Feature> findFeatureById(Long id);
}