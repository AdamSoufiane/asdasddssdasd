package application.services;

import application.ports.out.FeaturePersistencePort;
import domain.entities.Feature;

public class FeatureService {

    private final FeaturePersistencePort featurePersistencePort;

    public FeatureService(FeaturePersistencePort featurePersistencePort) {
        this.featurePersistencePort = featurePersistencePort;
    }

    public Feature executeFeatureLogic(Feature feature) {
        // Business logic for the feature would be executed here.
        // This could involve calling other methods, handling transactions, etc.

        // For example, persisting the feature using the output port:
        return featurePersistencePort.saveFeature(feature);
    }

    // Additional methods related to the feature's business logic could be implemented here.
}
