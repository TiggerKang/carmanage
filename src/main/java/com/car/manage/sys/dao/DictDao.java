package com.car.manage.sys.dao;

import com.car.manage.sys.entity.Dict;
import com.car.manage.sys.entity.QueryDict;

import java.util.List;

public interface DictDao {

    /**
     * 功能描述：实现统计总的字典数据
     * @param query
     * @return
     */
    int count(QueryDict query);

    /**
     * 功能描述：实现数据字典分页查询
     * @param query
     * @return
     */
    List<Dict> findByPage(QueryDict query);

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
