package com.zkml.official_reception.server.dao;

import com.zkml.official_reception.server.po.ColumnPO;
import com.zkml.official_reception.server.po.ColumnPOVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fanghui on 2019/6/14.
 */
public interface ColumnDAO {
    /**
     * 新增一个记录
     *
     * @param columnPO 记录信息，没填的信息为空
     * @return 影响的行数 正常为1
     */
    int create(ColumnPO columnPO);

    /**
     * 根据id更新一条记录
     *
     * @param columnPO 记录信息，没填的信息不更新
     * @return 影响的行数 正常为1
     */

    int updateColumn(ColumnPO columnPO);
    /**
     * 根据id更新一条记录
     *
     * @param columnPO 记录信息, 为空的更新为NULL
     * @return 影响的行数 正常为1
     */
    int update4Null(ColumnPO columnPO);

    /**
     * 删除一条记录
     *
     * @param columnId
     * @return 影响的行数 正常为1
     */
    int delete(@Param("columnId") String columnId);

    /**
     * 根据columnId查找
     *
     * @param columnId
     * @return PO
     */
    ColumnPO findByColumnId(@Param("columnId") String columnId);

    /**
     * 查询主题下的所有栏目
     * @param titleId
     * @return
     */
    List<ColumnPOVO> findByTitleId(@Param("titleId") String titleId);
}
