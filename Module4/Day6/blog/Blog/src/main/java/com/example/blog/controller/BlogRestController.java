package com.example.blog.controller;
import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Blog")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public ResponseEntity<Page<Blog>> showList(@RequestParam(defaultValue = "") String search,
                                               @PageableDefault(sort = {"id"},direction = Sort.Direction.DESC,size = 3) Pageable pageable) {
        return new ResponseEntity<>(iBlogService.findByName(search,pageable), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(Blog Blog) {
        iBlogService.save(Blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("")
    public ResponseEntity<Blog> delete(@RequestParam(name = "id") Integer id) {
        iBlogService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("edit")
    public ResponseEntity<Blog> edit(Blog Blog) {
        iBlogService.save(Blog);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}