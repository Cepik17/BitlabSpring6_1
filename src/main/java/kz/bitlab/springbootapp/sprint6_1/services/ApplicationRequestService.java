package kz.bitlab.springbootapp.sprint6_1.services;

import kz.bitlab.springbootapp.sprint6_1.models.ApplicationRequest;

import java.util.List;

public interface ApplicationRequestService {
    List<ApplicationRequest> getAllApps();
    List<ApplicationRequest> getAllNewApps();
    List<ApplicationRequest> getAllOldApps();
    ApplicationRequest getAppById(Long id);
    void deleteAppById(Long id);
    void createNewApp(ApplicationRequest applicationRequest);
    void setAppHandled(Long id);
}
