package io.cozyshare.backend.service;

import io.cozyshare.backend.model.SharedFile;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FileNumberService {
    private Random r = new Random();

    public int generateFileNumber(){
        //TODO change this method to generate unique file name
        return r.nextInt(1000000);
    }

}
