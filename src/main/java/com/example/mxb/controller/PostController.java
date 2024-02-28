package com.example.mxb.controller;

import com.example.mxb.entity.Post;
import com.example.mxb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;



    @RequestMapping("/insert")
    public String insert(@RequestBody Post post) {
        postService.save(post);
        return "添加成功";
    }

    @RequestMapping("/selectAll")
    public List<Post> selectAll() {
        List<Post> list = postService.list();
        return list;
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        postService.removeById(id);
        return "删除成功";
    }


    @RequestMapping("/update")
    public String update(@RequestBody Post post){
        postService.updateById(post);
        return "修改成功";
    }
}
