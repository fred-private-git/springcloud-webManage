package com.zkml.official_reception.server.dao;

import com.zkml.official_reception.server.po.ReceptionLetterPO;
import org.apache.ibatis.annotations.Param;

/**
 * Created by fanghui on 2019/5/17.
 */
public interface ReceptionLetterDAO {

    /**
     * 新增一个接待方案记录
     *
     * @param receptionLetterPO 记录信息，没填的信息为空
     * @return 影响的行数 正常为1
     */
    int create(@Param("receptionLetterPO")  ReceptionLetterPO receptionLetterPO);

    /**
     * 根据id更新一个接待方案记录
     *
     * @param receptionLetterPO 记录信息，没填的信息不更新
     * @return 影响的行数 正常为1
     */
    int update(@Param("receptionLetterPO")  ReceptionLetterPO receptionLetterPO);


    /**
     * 删除一条记录
     *
     * @param officialLetter
     * @return 影响的行数 正常为1
     */
    int delete(@Param("officialLetter") String officialLetter);

    /**
     * 根据receptionLetterId查找
     *
     * @param receptionLetterId
     */
    ReceptionLetterPO findByReceptionLetterId(@Param("receptionLetterId") String receptionLetterId);
}
