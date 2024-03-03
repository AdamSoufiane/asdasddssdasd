package application.ports.in;

import domain.entities.FeatureInput;
import domain.entities.FeatureResult;

public interface FeatureServicePort {

    FeatureResult performFeatureOperation(FeatureInput input);

}