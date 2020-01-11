package com.leyou.item.web;

import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import com.leyou.item.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: ls
 * @description:
 * @create: 2020-01-11 23:17
 */
@RestController
@RequestMapping("spec")
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;

    /**
     * 根据分类id查询分组
     * @param cid
     * @return
     */
    @GetMapping("groups/{cid}")
    public ResponseEntity<List<SpecGroup>> queryGroupsByCid(@PathVariable("cid")Long cid){
        List<SpecGroup> groups = this.specificationService.queryGroupsByCid(cid);
        if (CollectionUtils.isEmpty(groups)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(groups);
    }


    /**
     * 根据条件查询规格参数
     * @param gid
     * @return
     */
    @GetMapping("params")
    public ResponseEntity<List<SpecParam>> queryParams(@RequestParam("gid")Long gid){
        List<SpecParam>  params = this.specificationService.queryParams(gid);
        if (CollectionUtils.isEmpty(params)){
            System.out.println(params);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(params);
    }


    @PostMapping("groups")
    public ResponseEntity<Void> saveGroup(@RequestBody SpecGroup specGroup){
        this.specificationService.saveGroup(specGroup);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PostMapping("groups")
    public ResponseEntity<Void> saveGroup(@RequestBody SpecGroup specGroup){
        this.specificationService.updateGroup(specGroup);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @DeleteMapping("groups")
    public ResponseEntity<Void> deleteGroup(@RequestBody SpecGroup specGroup){
        this.specificationService.deleteGroup(specGroup);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

 /*   @PostMapping
    public ResponseEntity<Void> saveBrand(@RequestParam(value = "cids") List<Long> categories, Brand brand) {
        this.brandService.saveBrand(categories, brand);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    *//**
     *  品牌的修改
     * @param categories
     * @param brand
     * @return
     *//*
    @PutMapping
    public ResponseEntity<Void> updateBrand(@RequestParam(value = "cids") List<Long> categories, Brand brand) {
        this.brandService.updateBrand(categories, brand);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


    *//**
     * 品牌的删除
     * @param bid
     * @return
     *//*
    @DeleteMapping
    public ResponseEntity<Void> deleteBrand(@RequestParam(value = "id")Long bid){
        this.brandService.deleteBrand(bid);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }*/

}
