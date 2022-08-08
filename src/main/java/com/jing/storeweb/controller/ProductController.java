package com.jing.storeweb.controller;

import com.jing.storeweb.entity.Product;
import com.jing.storeweb.service.IProductService;
import com.jing.storeweb.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController extends BaseController {
    @Autowired
    private IProductService productService;

    @RequestMapping("hot_list")
    public JsonResult<List<Product>> getHotList() {
        List<Product> data = productService.findHotList();
        return new JsonResult<>(OK, data);
    }

    @GetMapping("{id}/details")
    public JsonResult<Product> getById(@PathVariable("id") Integer id) {
        Product data = productService.findById(id);
        return new JsonResult<>(OK, data);
    }
}
