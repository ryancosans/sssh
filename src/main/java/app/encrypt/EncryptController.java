package app.encrypt;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.common.Secret;

@RestController
public class EncryptController {

  @RequestMapping(method=RequestMethod.GET, path="/encrypt")
  public String encrypt(
    @RequestParam(value="message", defaultValue="nothinghere") String message,
    @RequestParam(value="secret", defaultValue="sssh") String secret) {
      return new Secret(message, secret).encrypt();
  }
}