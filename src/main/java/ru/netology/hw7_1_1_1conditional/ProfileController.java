package ru.netology.hw7_1_1_1conditional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProfileController {
    public SystemProfile profile;

    public ProfileController(SystemProfile profile){
        this.profile = profile;
    }
    @GetMapping("/")
    public String getProfile(){
        return profile.getProfile();
    }
}
