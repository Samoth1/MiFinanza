package com.tingeso.resumenmov.services;

import com.tingeso.resumenmov.models.EgresoModel;
import com.tingeso.resumenmov.models.IngresoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ResumenMovService {
    @Autowired
    RestTemplate restTemplate;

    // REST CONTROLLER PARA EGRESO
    public String getEgreso(Date fecha){
        return restTemplate.getForObject("http://egreso-service/egreso"+ fecha, String.class);
    }
    public String saveEgreso(Date fecha){
        return restTemplate.getForObject("http://egreso-service/egreso"+ fecha, String.class);
    }
}
