package nip;

public class MaskPassword {
	public String removePasswordFromJsonString(String jsonString){
	  if (jsonString == null) {
	    return null;
	  }

	  // Replace all password values with empty strings
	  return jsonString.replaceAll("(\\n?\\s*\"dbPassword\"\\s*:\\s*\")[^\\n\"]*(\",?\\n?)", "$1$2");
	}
}
