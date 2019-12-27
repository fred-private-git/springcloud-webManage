package com.zkml.official_reception.server.dao;

import com.zkml.official_reception.client.query.ReceptionQuery;
import com.zkml.official_reception.server.po.ChildColumnDetailPO;
import com.zkml.official_reception.server.po.ColumnFoodPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fanghui on 2019/6/17.
 */
public interface ChildColumnDetailDAO {
    /**
     * 新增一个记录
     *
     * @param childColumnDetailPO 记录信息，没填的信息为空
     * @return 影响的行数 正常为1
     */
    int createDetail(ChildColumnDetailPO childColumnDetailPO);

    /**
     * 根据id更新一条记录
     *
     * @param childColumnDetailPO 记录信息，没填的信息不更新
     * @return 影响的行数 正常为1
     */

    int updateDetailById(ChildColumnDetailPO childColumnDetailPO);
    /**
     * 根据id更新一条记录
     *
     * @param childColumnDetailPO 记录信息, 为空的更新为NULL
     * @return 影响的行数 正常为1
     */
    int update4Null(ChildColumnDetailPO childColumnDetailPO);

    /**
     * 删除一条记录
     *
     * @param childColumnDetailId
     * @return 影响的行数 正常为1
     */
    int deleteDetailById(@Param("childColumnDetailId") String childColumnDetailId);

    /**
     * 根据childColumnDetailId查找
     *
     * @param childColumnDetailId
     * @return ChildColumnDetailPO
     */
    ChildColumnDetailPO findByChildColumnDetailId(@Param("childColumnDetailId") String childColumnDetailId);

    /**
     * 子栏目内容分页列表
     * @param receptionQuery
     * @param offset
     * @param max
     * @return
     */
    List<ChildColumnDetailPO> findWithPage(@Param("receptionQuery") ReceptionQuery receptionQuery, @Param("offset") long offset, @Param("max") long max);
    /**
     * 子栏目内容记录总数
     * @param receptionQuery
     * @return
     */
    Long findCountWithPage(@Param("receptionQuery") ReceptionQuery receptionQuery);
}
