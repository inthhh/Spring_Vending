package com.study.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ApiController {
    
    private List<ProductDto> productList = new ArrayList<>();
    
    @GetMapping("/products")
    public List<ProductDto> products(){
        return productList;
    }
    
    @PostMapping("/add")
    public ResponseEntity<PostResponseDto> add(@RequestBody ProductDto req){
        productList.add(req);
        return ResponseEntity.ok(new PostResponseDto("ok")); // ✅ 항상 JSON 응답
    }
}
