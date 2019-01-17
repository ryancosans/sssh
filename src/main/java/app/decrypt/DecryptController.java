package app.decrypt;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.common.Secret;

@RestController
public class DecryptController {

  @RequestMapping(method=RequestMethod.GET, path="/decrypt")
  public String decrypt(
    @RequestParam(value="message", defaultValue="nothinghere") String message,
    @RequestParam(value="secret", defaultValue="sssh") String secret) {
      return new Secret(message, secret).decrypt();
  }
}