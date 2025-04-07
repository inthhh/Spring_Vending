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
    
    @GetMapping("/product")
    public ResponseEntity<ProductDto> getOneProduct(@RequestParam("index") int index) {
        if (index >= 0 && index < productList.size()) {
            return ResponseEntity.ok(productList.get(index));
        } else {
            return ResponseEntity.badRequest().build(); // 인덱스 범위 오류
        }
    }
    
    @PostMapping("/edit")
    public ResponseEntity<PostResponseDto> edit(@RequestBody EditDto req){
        ProductDto updated = new ProductDto(
                req.getName(),
                req.getPrice(),
                req.getLimit_date()
        );
        productList.set(req.getIndex(), updated);
        return ResponseEntity.ok(new PostResponseDto("ok")); // ✅ 항상 JSON 응답
    }
    
    @DeleteMapping("/remove")
    public ResponseEntity<PostResponseDto> remove(@RequestParam("index") int index) {
        if (index >= 0 && index < productList.size()) {
            productList.remove(index);
            return ResponseEntity.ok(new PostResponseDto("ok"));
        } else {
            return ResponseEntity.badRequest().body(new PostResponseDto("fail"));
        }
    }
    
}
