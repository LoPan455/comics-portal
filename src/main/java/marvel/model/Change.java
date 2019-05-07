package marvel.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = Change.COLLECTION)
public class Change {

  public static final String COLLECTION = "change";
  public static final String ID = "object_id";
  public static final String MODIFIED = "modified";
  public static final String CLASS = "object_class";
  public static final String TYPE = "change_type";

  @Id
  private String id;
  @Field(ID)
  private String objectId;
  @Field(TYPE)
  private ChangeType type;
  @Field(MODIFIED)
  private Date modified = new Date();
  @Field(CLASS)
  private String objectClass;

  public enum ChangeType {
    ADDED,
    ALTERED,
    DELETED
  }

  public Change(){

  }

  public Change(String objectId, ChangeType type, String objectClass) {
    this.objectId = objectId;
    this.type = type;
    this.objectClass = objectClass;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getObjectId() {
    return objectId;
  }

  public void setObjectId(String objectId) {
    this.objectId = objectId;
  }

  public ChangeType getType() {
    return type;
  }

  public void setType(ChangeType type) {
    this.type = type;
  }

  public Date getModified() {
    return modified;
  }

  public void setModified(Date modified) {
    this.modified = modified;
  }

  public String getObjectClass() {
    return objectClass;
  }

  public void setObjectClass(String objectClass) {
    this.objectClass = objectClass;
  }

  public static String getCOLLECTION() {
    return COLLECTION;
  }

}
