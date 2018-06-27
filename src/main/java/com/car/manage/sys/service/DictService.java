package com.car.manage.sys.service;

import com.car.manage.sys.dao.DictDao;
import com.car.manage.sys.entity.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor={IllegalArgumentException.class})
public class DictService {

    @Autowired
    private DictDao dictDao;

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
