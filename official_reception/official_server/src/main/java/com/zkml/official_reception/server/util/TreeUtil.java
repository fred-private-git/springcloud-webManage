package com.zkml.official_reception.server.util;

/**
 * Created by fanghui on 2019/5/31.
 */

import com.zkml.official_reception.server.po.TreePO;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 类名称：TreeUtil
 * 类描述：递归构造树型结构
 */
public class TreeUtil {

    public static Map<String,Object> mapArray = new LinkedHashMap<String, Object>();
    public List<TreePO> menuCommon;
    public List<Object> list = new ArrayList<Object>();

    public List<Object> list(List<TreePO> menu){
        this.menuCommon = menu;
        for (TreePO x : menu) {
            Map<String,Object> mapArr = new LinkedHashMap<String, Object>();
            if(x.getPId().equals("00")){
                mapArr.put("id", x.getId());
                mapArr.put("name", x.getName());
                mapArr.put("pid", x.getPId());
                mapArr.put("childList", Children(x.getId()));
                list.add(mapArr);
            }
        }
        return list;
    }

    public List<?> Children(String id){
        List<Object> lists = new ArrayList<Object>();
        for(TreePO a:menuCommon){
            Map<String,Object> childArray = new LinkedHashMap<String, Object>();
            if(a.getPId() .equals(id)){
                childArray.put("id", a.getId());
                childArray.put("name", a.getName());
                childArray.put("pid", a.getPId());
                childArray.put("childList", Children(a.getId()));
                lists.add(childArray);
            }
        }
        return lists;
    }

}
