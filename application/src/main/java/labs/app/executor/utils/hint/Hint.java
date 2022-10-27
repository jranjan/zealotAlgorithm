package labs.app.executor.utils.hint;

import java.util.HashMap;
import java.util.Map;

public class Hint {
  private Map<String, String> hintStore = new HashMap<String, String>();

  public String setHint(String key, String value){
      String previousValue = this.getHint(key);
      this.hintStore.put(key, value);
      return previousValue;
  }

  public String getHint(String key) {
    return this.hintStore.get(key);
  }

  public int getCount() {
    return this.hintStore.size();
  }
}
