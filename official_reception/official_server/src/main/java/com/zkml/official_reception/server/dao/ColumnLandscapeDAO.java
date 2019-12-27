package com.zkml.official_reception.server.dao;

import com.zkml.official_reception.client.query.ReceptionQuery;
import com.zkml.official_reception.server.po.ColumnLandscapePO;
import com.zkml.official_reception.server.po.ColumnPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fanghui on 2019/6/14.
 */
public interface ColumnLandscapeDAO {
    /**
     * 新增一个山水风光记录
     *
     * @param columnLandscape 记录信息，没填的信息为空
     * @return 影响的行数 正常为1
     */
    int createLandscape(ColumnLandscapePO columnLandscape);

    /**
     * 根据id更新一条记录
     *
     * @param columnLandscape 记录信息，没填的信息不更新
     * @return 影响的行数 正常为1
     */

    int updateLandscapeById(ColumnLandscapePO columnLandscape);
    /**
     * 根据id更新一条记录
     *
     * @param columnLandscape 记录信息, 为空的更新为NULL
     * @return 影响的行数 正常为1
     */
    int update4Null(ColumnLandscapePO columnLandscape);

    /**
     * 删除一条山水风光记录
     *
     * @param columnLandscapeId
     * @return 影响的行数 正常为1
     */
    int deleteLandscapeById(@Param("columnLandscapeId") String columnLandscapeId);

    /**
     * 根据columnLandscapeId查找
     *
     * @param columnLandscapeId
     * @return ColumnLandscapePO
     */
    ColumnLandscapePO findByColumnLandscapeId(@Param("columnLandscapeId") String columnLandscapeId);
    /**
     * 山水风光分页列表
     * @param receptionQuery
     * @param offset
     * @param max
     * @return
     */
    List<ColumnLandscapePO> findWithPage(@Param("receptionQuery") ReceptionQuery receptionQuery, @Param("offset") long offset, @Param("max") long max);
    /**
     * 山水风光记录总数
     * @param receptionQuery
     * @return
     */
    Long findCountWithPage(@Param("receptionQuery") ReceptionQuery receptionQuery);





}
