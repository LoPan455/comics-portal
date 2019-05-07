package marvel.service;

import org.springframework.core.GenericTypeResolver;

public interface ParameterAware<T> {

  default Class<T> getGenericType() {
    return (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), ParameterAware.class);
  }

}
