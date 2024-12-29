package com.example.upload_image.Profile;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public String CreateProfile(String name,MultipartFile image) throws IOException {
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setName(name);
        profileEntity.setProfilePhoto(image.getBytes());
        profileRepository.save(profileEntity);
        return "Profile Created";
    }

}
