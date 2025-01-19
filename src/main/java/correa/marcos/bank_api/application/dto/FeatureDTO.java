package correa.marcos.bank_api.application.dto;

import correa.marcos.bank_api.domain.model.Feature;

public record FeatureDTO(Long id,
                         String cod,
                         String icon,
                         String description) {

    public FeatureDTO(Feature feature){
        this(feature.getId(),
                feature.getCod(),
                feature.getIcon(),
                feature.getDescription());
    }

    public Feature toDomain(){
        return new Feature(
                this.id,
                this.cod,
                this.icon,
                this.description);
    }
}
