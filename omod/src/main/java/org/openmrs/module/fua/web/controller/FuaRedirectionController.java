package org.openmrs.module.fua.web.controller;

import org.openmrs.module.fua.web.utils.MultipartInputStreamFileResource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.client.RestTemplate;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FuaRedirectionController {

    @RequestMapping(value = "/FUAFormat", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> redirectFuaRequest(
            @RequestParam("name") String name,
            @RequestParam("createdBy") String createdBy,
            @RequestParam("formatPayload") MultipartFile formatPayload
    ) throws IOException {

        HttpHeaders headers = new HttpHeaders();
        headers.set("fuagentoken", "fuagenerator");
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("name", name);
        body.add("createdBy", createdBy);
        body.add("formatPayload", new MultipartInputStreamFileResource(
                formatPayload.getInputStream(),
                formatPayload.getOriginalFilename(),
                formatPayload.getSize()
        ));

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:3000/ws/FUAFormat", requestEntity, String.class);
        //ResponseEntity<String> response = restTemplate.postForEntity("http://hii1sc-dev.inf.pucp.edu.pe/services/fua-generator/ws/FUAFormat", requestEntity, String.class);

        return ResponseEntity
                .status(response.getStatusCode())
                .contentType(MediaType.APPLICATION_JSON)
                .body(response.getBody());
    }

    @RequestMapping(value = "/FUAFormat1", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> redirectFuaRequest1(
            @RequestParam("name") String name,
            @RequestParam("createdBy") String createdBy,
            @RequestParam("formatPayload") MultipartFile formatPayload
    ) throws IOException {

        HttpHeaders headers = new HttpHeaders();
        headers.set("fuagentoken", "fuagenerator");
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("name", name);
        body.add("createdBy", createdBy);
        body.add("formatPayload", new MultipartInputStreamFileResource(
                formatPayload.getInputStream(),
                formatPayload.getOriginalFilename(),
                formatPayload.getSize()
        ));

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity("http://fua-generator:3000/ws/FUAFormat", requestEntity, String.class);
        //ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/openmrs/services/fua-generator/ws/FUAFormat", requestEntity, String.class);

        return ResponseEntity
                .status(response.getStatusCode())
                .contentType(MediaType.APPLICATION_JSON)
                .body(response.getBody());
    }

    @RequestMapping(value = "/FUAFormat2", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> redirectFuaRequest2(
            @RequestParam("name") String name,
            @RequestParam("createdBy") String createdBy,
            @RequestParam("formatPayload") MultipartFile formatPayload
    ) throws IOException {

        HttpHeaders headers = new HttpHeaders();
        headers.set("fuagentoken", "fuagenerator");
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("name", name);
        body.add("createdBy", createdBy);
        body.add("formatPayload", new MultipartInputStreamFileResource(
                formatPayload.getInputStream(),
                formatPayload.getOriginalFilename(),
                formatPayload.getSize()
        ));

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        //ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:3000/ws/FUAFormat", requestEntity, String.class);
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/services/fua-generator/ws/FUAFormat", requestEntity, String.class);

        return ResponseEntity
                .status(response.getStatusCode())
                .contentType(MediaType.APPLICATION_JSON)
                .body(response.getBody());
    }

        @RequestMapping(value = "/FUAFormat3", method = RequestMethod.POST)
        @ResponseBody
        public ResponseEntity<String> redirectFuaRequest3(
                @RequestParam("name") String name,
                @RequestParam("createdBy") String createdBy,
                @RequestParam("formatPayload") MultipartFile formatPayload,
                HttpServletRequest request // 👈 añadimos para detectar el host y puerto
        ) throws IOException {

        HttpHeaders headers = new HttpHeaders();
        headers.set("fuagentoken", "fuagenerator");
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("name", name);
        body.add("createdBy", createdBy);
        body.add("formatPayload", new MultipartInputStreamFileResource(
                formatPayload.getInputStream(),
                formatPayload.getOriginalFilename(),
                formatPayload.getSize()
        ));

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        // 🔧 Construir dinámicamente la URL base según el entorno
        String scheme = request.getScheme(); // http o https
        String serverName = request.getServerName(); // localhost, hii1sc-qlty.inf.pucp.edu.pe, etc.
        int serverPort = request.getServerPort(); // 8080, 80, etc.

        // Intentamos obtener el contexto (si OpenMRS está desplegado en /openmrs o raíz)
        String contextPath = request.getContextPath(); // devuelve "/openmrs" o "" según el caso

        // Armamos la URL completa
        String fuaUrl = String.format("%s://%s:%d%s/services/fua-generator/ws/FUAFormat",
                scheme, serverName, serverPort, contextPath);

        // 🚀 Hacemos la llamada dinámica
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(fuaUrl, requestEntity, String.class);

        return ResponseEntity
                .status(response.getStatusCode())
                .contentType(MediaType.APPLICATION_JSON)
                .body(response.getBody());
        }


        @RequestMapping(value = "/FUAFormat4", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> redirectFuaRequest4(
            @RequestParam("name") String name,
            @RequestParam("createdBy") String createdBy,
            @RequestParam("formatPayload") MultipartFile formatPayload
    ) throws IOException {

        HttpHeaders headers = new HttpHeaders();
        headers.set("fuagentoken", "fuagenerator");
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("name", name);
        body.add("createdBy", createdBy);
        body.add("formatPayload", new MultipartInputStreamFileResource(
                formatPayload.getInputStream(),
                formatPayload.getOriginalFilename(),
                formatPayload.getSize()
        ));

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        //ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:3000/ws/FUAFormat", requestEntity, String.class);
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:3000/ws/FUAFormat", requestEntity, String.class);

        return ResponseEntity
                .status(response.getStatusCode())
                .contentType(MediaType.APPLICATION_JSON)
                .body(response.getBody());
    }


    @RequestMapping(value = "/FUAFormat5", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> redirectFuaRequest5(
            @RequestParam("name") String name,
            @RequestParam("createdBy") String createdBy,
            @RequestParam("formatPayload") MultipartFile formatPayload
    ) throws IOException {

        HttpHeaders headers = new HttpHeaders();
        headers.set("fuagentoken", "fuagenerator");
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("name", name);
        body.add("createdBy", createdBy);
        body.add("formatPayload", new MultipartInputStreamFileResource(
                formatPayload.getInputStream(),
                formatPayload.getOriginalFilename(),
                formatPayload.getSize()
        ));

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        //ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:3000/ws/FUAFormat", requestEntity, String.class);
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:3000/openmrs/ws/FUAFormat", requestEntity, String.class);

        return ResponseEntity
                .status(response.getStatusCode())
                .contentType(MediaType.APPLICATION_JSON)
                .body(response.getBody());
    }



    
}
