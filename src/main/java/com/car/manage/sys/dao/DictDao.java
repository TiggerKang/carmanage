package com.car.manage.sys.dao;

import com.car.manage.sys.entity.Dict;

public interface DictDao {

    /**
     * 功能描述：根据ID来获取数据字典的数据
     * @param dict
     * @return
     */
    Dict getDictById(Dict dict);

    /**
     * 功能描述：实现增加数据
     * @param dict
     * @return
     */
    int saveDict(Dict dict);

    /**
     * 功能描述：根据ID来更新数据字典数据
     * @param dict
     * @return
     */
    int updateDictById(Dict dict);

    /**
     * 功能描述：根据ID来删除数据字典数据
     * @param dict
     * @return
     */
    int deleteById(Dict dict);



}
