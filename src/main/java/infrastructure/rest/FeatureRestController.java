package infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import application.services.FeatureService;
import domain.entities.Feature;
import infrastructure.rest.dto.FeatureInputDto;
import infrastructure.rest.dto.FeatureResponseDto;

@RestController
@RequestMapping("/features")
public class FeatureRestController {

    private final FeatureService featureService;

    @Autowired
    public FeatureRestController(FeatureService featureService) {
        this.featureService = featureService;
    }

    @PostMapping
    public ResponseEntity<FeatureResponseDto> createFeature(@Valid @RequestBody FeatureInputDto featureInput) {
        Feature feature = featureService.executeFeatureLogic(featureInput);
        return ResponseEntity.ok(new FeatureResponseDto(feature));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeatureResponseDto> getFeature(@PathVariable Long id) {
        Feature feature = featureService.findFeatureById(id);
        return ResponseEntity.ok(new FeatureResponseDto(feature));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeatureResponseDto> updateFeature(@PathVariable Long id, @Valid @RequestBody FeatureInputDto featureInput) {
        Feature feature = featureService.updateFeature(id, featureInput);
        return ResponseEntity.ok(new FeatureResponseDto(feature));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeature(@PathVariable Long id) {
        featureService.deleteFeature(id);
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleExceptions(Exception e) {
        // Custom exception handling logic
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

}