package com.car.manage.sys.service;

import com.car.manage.sys.dao.DictDao;
import com.car.manage.sys.entity.Dict;
import com.car.manage.sys.entity.Page;
import com.car.manage.sys.entity.QueryDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor={IllegalArgumentException.class})
public class DictService {

    @Autowired
    private DictDao dictDao;

    /**
     * 功能描述：分页的统一调用方法
     * @param query
     * @return
     */
    public Page findByPage(QueryDict query){
        return new Page(dictDao.findByPage(query),dictDao.count(query));
    }


    /**
     * 功能描述：分页的分开调用方法
     * @param query
     * @return
     */
    public List<Dict> findByPage1(QueryDict query){
        return dictDao.findByPage(query);
    }

    /**
     * 功能描述：实现统计总的字典数据
     * @param query
     * @return
     */
    public int count(QueryDict query){
        return dictDao.count(query);
    }

    /**
     * 功能描述：根据ID来获取数据字典的数据
     * @param entity
     * @return
     */
    public Dict getDictById(Dict entity){
        return dictDao.getDictById(entity);
    }

    /**
     * 功能描述：实现增加数据
     * @param entity
     * @return
     */
    public int saveDict(Dict entity){
        return dictDao.saveDict(entity);
    }

    /**
     * 功能描述：根据ID来更新数据字典数据
     * @param dict
     * @return
     */
    public int updateDictById(Dict dict){
        return dictDao.updateDictById(dict);
    }

    /**
     * 功能描述：根据ID来删除数据字典的数据
     * @param dict
     * @return
     */
    public int deleteById(Dict dict){
        return dictDao.deleteById(dict);
    }



}
