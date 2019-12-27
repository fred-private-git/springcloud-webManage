package com.zkml.official_reception.server.dao;

import com.zkml.official_reception.server.po.ChildColumnPO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by fanghui on 2019/6/17.
 */
public interface ChildColumnDAO {
    /**
     * 新增一个记录
     *
     * @param childColumnPO 记录信息，没填的信息为空
     * @return 影响的行数 正常为1
     */
    int createChildColumn(ChildColumnPO childColumnPO);

    /**
     * 根据id更新一条记录
     *
     * @param childColumnPO 记录信息，没填的信息不更新
     * @return 影响的行数 正常为1
     */

    int updateChildColumnById(ChildColumnPO childColumnPO);
    /**
     * 根据id更新一条记录
     *
     * @param childColumnPO 记录信息, 为空的更新为NULL
     * @return 影响的行数 正常为1
     */
    int update4Null(ChildColumnPO childColumnPO);

    /**
     * 删除一条记录
     *
     * @param childColumnId
     * @return 影响的行数 正常为1
     */
    int deleteChildColumnById(@Param("childColumnId") String childColumnId);

    /**
     * 根据childColumnId查找
     *
     * @param childColumnId
     * @return ChildColumnPO
     */
    ChildColumnPO findByChildColumnId(@Param("childColumnId") String childColumnId);


    /**
     * 根据栏目id查询子栏目
     * @param columnId
     * @return
     */
    List<ChildColumnPO> findChildByColumnId(@Param("columnId") String columnId);

}
