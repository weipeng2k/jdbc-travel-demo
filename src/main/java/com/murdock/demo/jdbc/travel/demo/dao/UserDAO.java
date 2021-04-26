package com.murdock.demo.jdbc.travel.demo.dao;

import com.murdock.demo.jdbc.travel.demo.dao.dataobject.UserDO;
import com.murdock.demo.jdbc.travel.demo.dao.param.QueryUserListDAOParam;

import java.util.List;

/**
 * @author weipeng2k 2021年04月26日 下午14:33:05
 */
public interface UserDAO {

    /**
     * 新增一条会员
     *
     * @param userDO 会员
     * @return 影响行数
     */
    int insetUser(UserDO userDO);

    /**
     * 根据主键查询
     *
     * @param id id
     * @return 会员
     */
    UserDO queryUser(Long id);

    /**
     * 查询列表，分页
     *
     * @param param 查询参数
     * @param skip  越过
     * @param limit 拿多少
     * @return 分页数据，如果为空，返回空集合
     */
    List<UserDO> queryUserList(QueryUserListDAOParam param, int skip, int limit);

    /**
     * count数据
     *
     * @param param 查询参数
     * @return 数量
     */
    int countUserList(QueryUserListDAOParam param);

    /**
     * 获取最大ID
     *
     * @param param 参数
     * @return max id
     */
    long getMaxUserId(QueryUserListDAOParam param);

    /**
     * 获取最小ID
     *
     * @param param 参数
     * @return min id
     */
    long getMinUserId(QueryUserListDAOParam param);

    /**
     * 遍历
     *
     * @param startIncludeId 起始
     * @param endExcludeId   结束
     * @return 区段数据
     */
    List<UserDO> scanUserList(Long startIncludeId, Long endExcludeId);

}
