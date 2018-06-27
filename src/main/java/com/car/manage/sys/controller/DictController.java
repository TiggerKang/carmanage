package com.car.manage.sys.controller;

import com.car.manage.sys.entity.Dict;
import com.car.manage.sys.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping(value="/dict")
public class DictController {

    @Autowired
    private DictService dictService;

    /**
     * 功能描述：根据ID来删除数据字典的数据
     * @param entity
     * @return
     */
    @RequestMapping(value="delete",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> delete(Dict entity){
        Map<String,Object> result = new HashMap<>();
        if(dictService.deleteById(entity)>0){
            result.put("msg","删除字典数据成功");
        }else{
            result.put("msg","删除字典数据失败");
        }
        return result;
    }

    /**
     * 功能描述：根据ID来更新数据字典的数据
     * @param entity
     * @return
     */
    @RequestMapping(value="update",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> update(Dict entity){
        Map<String,Object> result = new HashMap<>();
        if(dictService.updateDictById(entity)>0){
            result.put("msg","更新字典数据成功");
        }else{
            result.put("msg","更新字典数据失败");
        }
        return result;
    }

    /**
     * 功能描述：保存数据字典的数据
     * @param entity
     * @return
     */
    @RequestMapping(value="save",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> save(Dict entity){
        Map<String,Object> result = new HashMap<>();
        dictService.saveDict(entity);
        if(entity.getId()!=0){
            result.put("msg","增加字典数据成功");
            result.put("id",entity.getId());
        }else{
            result.put("msg","增加字典数据失败");
        }
        return result;
    }

    /**
     * 功能描述：根据ID来获取数据字典的数据
     * @param entity
     * @return
     */
    @RequestMapping(value="getDict",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> getDict(Dict entity){
        Map<String,Object> result = new HashMap<>();
        result.put("entity",dictService.getDictById(entity));
        return result;
    }




}
