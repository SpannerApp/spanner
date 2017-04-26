package spannerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spannerapp.model.RegistrationFormModel;
import spannerapp.service.RegistrationService;

/**
 * Created by Siekacz on 25.04.2017.
 */
@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void registerUser(@RequestBody RegistrationFormModel model){ registrationService.registerNewUser(model); }


}
