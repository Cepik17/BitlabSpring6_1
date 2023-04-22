package kz.bitlab.springbootapp.sprint6_1.controllers;

import kz.bitlab.springbootapp.sprint6_1.models.ApplicationRequest;
import kz.bitlab.springbootapp.sprint6_1.services.ApplicationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private ApplicationRequestService applicationRequestService;

    @GetMapping("/")
    public String indexPage(Model model) {
        List<ApplicationRequest> apps = applicationRequestService.getAllApps();
        model.addAttribute("apps", apps);
        return "index";
    }

    @GetMapping("/appdetails/{id}")
    public String detailsPage(@PathVariable Long id, Model model) {
        ApplicationRequest applicationRequest = applicationRequestService.getAppById(id);
        if (applicationRequest != null) {
            model.addAttribute("app", applicationRequest);
            return "appdetails";
        }
        return "index";
    }

    @GetMapping("/newapp")
    public String newApp() {
        return "newapp";
    }

    @PostMapping("/addapp")
    public String addApp(ApplicationRequest applicationRequest) {
        applicationRequestService.createNewApp(applicationRequest);
        return "redirect:/";
    }

    @PostMapping("/sethandle")
    public String setHandle(@RequestParam Long id, Model model) {
//        System.out.println("asdfg");
//        System.out.println("id=" + id);
//        ApplicationRequest applicationRequest = applicationRequestService.getAppById(id);
//        System.out.println(applicationRequest.isHandled());
//        applicationRequest.setHandled(true);
        applicationRequestService.setAppHandled(id);
        //       model.addAttribute("id",id);
        return "redirect:/";
    }

    @PostMapping("/deleteapp")
    public String deleteApp(@RequestParam Long id) {
        applicationRequestService.deleteAppById(id);
        return "redirect:/";
    }

    @GetMapping("/onlynewapp")
    public String onlyNewApp(Model model) {
        List<ApplicationRequest> apps = applicationRequestService.getAllNewApps();
        if (apps != null) {
            model.addAttribute("apps", apps);
            return "onlynewapp";
        } else return "index";
    }

    @GetMapping("/onlyoldapp")
    public String onlyOldApp(Model model) {
        List<ApplicationRequest> apps = applicationRequestService.getAllOldApps();
        if (apps != null) {
            model.addAttribute("apps", apps);
            return "onlyoldapp";
        } else return "index";
    }
}
