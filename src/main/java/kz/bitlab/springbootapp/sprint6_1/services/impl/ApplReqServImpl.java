package kz.bitlab.springbootapp.sprint6_1.services.impl;

import kz.bitlab.springbootapp.sprint6_1.models.ApplicationRequest;
import kz.bitlab.springbootapp.sprint6_1.repositories.RequestRepository;
import kz.bitlab.springbootapp.sprint6_1.services.ApplicationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApplReqServImpl implements ApplicationRequestService {
    @Autowired
    private RequestRepository  requestRepository;

    @Override
    public List<ApplicationRequest> getAllApps() {
        return requestRepository.findAll();
    }

    @Override
    public List<ApplicationRequest> getAllNewApps() {
        return requestRepository.getAllNewApps();
    }

    @Override
    public List<ApplicationRequest> getAllOldApps() {
        return requestRepository.getAllOldApps();
    }

    @Override
    public ApplicationRequest getAppById(Long id) {
        return requestRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAppById(Long id) {
        requestRepository.deleteById(id);
    }

    @Override
    public void createNewApp(ApplicationRequest applicationRequest) {
        applicationRequest.setHandled(false);
        requestRepository.save(applicationRequest);
    }

    @Override
    public void setAppHandled(Long id) {
        ApplicationRequest applicationRequest = requestRepository.findById(id).orElse(null);
        assert applicationRequest != null;
        applicationRequest.setHandled(true);
        requestRepository.save(applicationRequest);
    }
}
