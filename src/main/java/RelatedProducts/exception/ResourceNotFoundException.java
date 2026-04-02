package RelatedProducts.exception;

import lombok.Getter;


public class ResourceNotFoundException extends RuntimeException{
    @Getter
    private final Object resourceId;
    private final Class<?> resourceType;
    public ResourceNotFoundException(Class<?> resourceType, Object resourceId){
        super(String.format("%s with id %s not found", resourceType.getSimpleName(), resourceId));
        this.resourceId = resourceId;
        this.resourceType = resourceType;
    }
    public String getResourceName(){
        return  this.resourceType.getSimpleName();
    }
}
