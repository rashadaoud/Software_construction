package ql.utils;

public enum MessageTypeEnum {
	error("Error: "),
	warning("Warning: ");
	
	private String message;

    private MessageTypeEnum(String message) {
      this.message = message;
    }

    public String getMessage() {
      return message;
    }
}
