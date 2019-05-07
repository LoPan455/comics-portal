package marvel.util;

import marvel.repository.MarvelDocument;

public interface ChangeMonitor<T extends MarvelDocument> {

  void register();

  void unregister();

}
