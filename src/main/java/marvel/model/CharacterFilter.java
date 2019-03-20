package marvel.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

@JsonFilter("does-not-work")
public abstract class CharacterFilter {
  public static final SimpleBeanPropertyFilter FILTER_PROPERTIES = SimpleBeanPropertyFilter.filterOutAllExcept("name", "resourceURI");
}
