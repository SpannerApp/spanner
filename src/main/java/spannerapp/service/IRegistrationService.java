package spannerapp.service;

import spannerapp.model.RegistrationFormModel;

/**
 * Created by Siekacz on 02.06.2017.
 */
public interface IRegistrationService {
    void registerNewUser(RegistrationFormModel model);
}
