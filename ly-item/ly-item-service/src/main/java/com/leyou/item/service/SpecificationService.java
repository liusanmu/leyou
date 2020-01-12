package com.leyou.item.service;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ls
 * @description:
 * @create: 2020-01-11 23:17
 */
@Service
public class SpecificationService {

    @Autowired
    private SpecGroupMapper specGroupMapper;

    @Autowired
    private SpecParamMapper specParamMapper;

    /**
     * 根据分类id查询分组
     * @param cid
     * @return
     */
    public List<SpecGroup> queryGroupsByCid(Long cid) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cid);
        return this.specGroupMapper.select(specGroup);
    }

    /**
     * 根据条件查询规格参数
     * @param gid
     * @return
     */
    public List<SpecParam> queryParams(Long gid, Long cid, Boolean generic, Boolean searching) {
        SpecParam record = new SpecParam();
        record.setGroupId(gid);
        record.setCid(cid);
        record.setGeneric(generic);
        record.setSearching(searching);
        return this.specParamMapper.select(record);
    }
    public void saveGroup(SpecGroup specGroup) {
        this.specGroupMapper.insert(specGroup);
    }

    public void updateGroup(SpecGroup specGroup) {
        int i = this.specGroupMapper.updateByPrimaryKey(specGroup);
        if (i != 1) {
            throw new LyException(ExceptionEnum.INSERT_OP_FAILD);
        }
    }

    public void deleteGroup(SpecGroup specGroup) {
        int i = this.specGroupMapper.delete(specGroup);
        if (i != 1) {
            throw new LyException(ExceptionEnum.INSERT_OP_FAILD);
        }
    }
}
