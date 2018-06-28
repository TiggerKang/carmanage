package com.car.manage.sys.controller;

import com.car.manage.sys.entity.Dict;
import com.car.manage.sys.entity.Page;
import com.car.manage.sys.entity.QueryDict;
import com.car.manage.sys.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping(value="/dict")
public class DictController {

    // Autowired相当于get和set方法
    @Autowired
    private DictService dictService;

    /**
     * 功能描述：获取分页数据
     * @param query
     * @return
     */
    @RequestMapping(value="list",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> list(QueryDict query){
        Map<String,Object> result = new HashMap<String, Object>();
        Page page = dictService.findByPage(query);
        result.put("totalCount",page.getTotal());
        result.put("result",page.getRows());
        return result;
    }

    /**
     * 功能描述：跳转到更新数据字典的页面
     * model.addAttribute("entity",entity); 相当于servlet的request.setattbi...("entity",entity)
     * @return
     */
    @RequestMapping(value="toUpdatePage",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String toUpdatePage(Dict entity,Model model){
        entity = dictService.getDictById(entity);
        model.addAttribute("entity",entity);
        return "sys/dict/update";
    }

    /**
     * 功能描述：跳转到增加数据字典页面
     * @return
     */
    @RequestMapping(value="toAddPage",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String toAddPage(){

        return "sys/dict/add";
    }

    /**
     * 功能描述：跳转到dictList页面
     * sys/dict/dictList return的这个值告诉我们的程序我们将跳转到sys目录的dict目录的dictList.html页面
     * @return
     */
    @RequestMapping(value="toDictList",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String toDictList(){

        return "sys/dict/dictList";
    }

    /**
     * 功能描述：根据ID来删除数据字典的数据
     * ResponseBody 相当于将后端的数据以json的形式返回给前端
     * 前端如何响应到这个方法：127.0.0.1:9090/dict/delete?id=xxx
     * @param entity
     * @return
     */
    @RequestMapping(value="delete",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> delete(Dict entity){
        Map<String,Object> result = new HashMap<>();
        if(dictService.deleteById(entity)>0){
            result.put("msg","删除字典数据成功");
            result.put("result",true);
        }else{
            result.put("msg","删除字典数据失败");
            result.put("result",false);
        }
        return result;
    }

    /**
     * 功能描述：根据ID来更新数据字典的数据
     * @param entity
     * @return
     */
    @RequestMapping(value="update",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> update(Dict entity){
        Map<String,Object> result = new HashMap<>();
        if(dictService.updateDictById(entity)>0){
            result.put("result",true);
            result.put("msg","更新字典数据成功");
        }else{
            result.put("result",false);
            result.put("msg","更新字典数据失败");
        }
        return result;
    }

    /**
     * 功能描述：保存数据字典的数据
     * @param entity
     * @return
     */
    @RequestMapping(value="save",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> save(Dict entity){
        Map<String,Object> result = new HashMap<>();
        dictService.saveDict(entity);
        if(entity.getId()!=0){
            result.put("result",true);
            result.put("msg","增加字典数据成功");
            result.put("id",entity.getId());
        }else{
            result.put("result",false);
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
