package xyz.parkh.campus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.parkh.campus.dto.ResponseDTO;
import xyz.parkh.campus.entity.TestEntity;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/test")
    public ResponseEntity<?> test(String msg) {
        ArrayList<String> list = new ArrayList<String>();
        if (msg == null) {
            list.add("test");
        } else {
            list.add(msg);
        }
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.ok().body(response);
    }

}
