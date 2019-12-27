package com.zkml.official_reception.server.dao;

import com.zkml.official_reception.server.po.TitlePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by fanghui on 2019/6/14.
 */
public interface TitleDAO {
    /**
     * 新增一个记录
     *
     * @param titlePO 记录信息，没填的信息为空
     * @return 影响的行数 正常为1
     */
    int create(TitlePO titlePO);

    /**
     * 根据id更新一条记录
     *
     * @param titlePO 记录信息，没填的信息不更新
     * @return 影响的行数 正常为1
     */

    int updateTitle(TitlePO titlePO);
    /**
     * 根据id更新一条记录
     *
     * @param titlePO 记录信息, 为空的更新为NULL
     * @return 影响的行数 正常为1
     */
    int update4Null(TitlePO titlePO);

    /**
     * 删除一条记录
     *
     * @param titleId
     * @return 影响的行数 正常为1
     */
    int delete(@Param("titleId") String titleId);

    /**
     * 根据titleId查找
     *
     * @param titleId
     * @return TitlePO
     */
    TitlePO findByTitleId(@Param("titleId") String titleId);

    /**
     * 查询所有的主题
     * @return TitlePO
     */
    List<TitlePO> findAll();

}
