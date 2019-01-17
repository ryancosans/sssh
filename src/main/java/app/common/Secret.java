package app.common;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@JsonIgnoreType
public class Secret {

  private final String message;
  private final String secret;
  private static final String cipher = "abcdefghijklmnopqrstuvwxyz";

  public Secret(String message, String secret) {
    while (secret.length() < message.length()) {
      secret += secret;
    }

    this.message = message;
    this.secret = secret.substring(0, message.length());
  }

  public String encrypt() {
    String encryptedMessage = "";
    for (int i = 0; i < message.length(); i++) {
      String messageChar =  "" + message.charAt(i);
      String[] ciperParts = cipher.split(messageChar);
      String tempCipher = messageChar + ciperParts[1] + ciperParts[0];
      String secretChar =  "" + secret.charAt(i);
      encryptedMessage += tempCipher.charAt( cipher.indexOf(secretChar) );
    }
    return encryptedMessage;
  }

  public String decrypt() {
    String decryptedMessage = "";
    for (int i = 0; i < secret.length(); i++) {
      String secretChar =  "" + secret.charAt(i);
      String[] ciperParts = cipher.split(secretChar);
      String tempCipher = secretChar + ciperParts[1] + ciperParts[0];
      String messageChar =  "" + message.charAt(i);
      decryptedMessage += cipher.charAt( tempCipher.indexOf(messageChar) );
    }
    return decryptedMessage;
  }

  /**
   * @return the secret
   */
  public String getSecret() {
    return secret;
  }

  /**
   * @return the message
   */
  public String getMessage() {
    return message;
  }
}