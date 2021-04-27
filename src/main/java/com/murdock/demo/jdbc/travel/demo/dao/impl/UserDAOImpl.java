package com.murdock.demo.jdbc.travel.demo.dao.impl;

import com.murdock.demo.jdbc.travel.demo.dao.UserDAO;
import com.murdock.demo.jdbc.travel.demo.dao.dataobject.UserDO;
import com.murdock.demo.jdbc.travel.demo.dao.param.QueryUserListDAOParam;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weipeng2k 2021年04月26日 下午14:44:46
 */
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

    private static final String NAMESPACE = UserDAO.class.getSimpleName();

    private static final String INSET_USER_ID = NAMESPACE + ".insertUser";
    private static final String QUERY_USER_LIST_ID = NAMESPACE + ".queryUserList";
    private static final String COUNT_USER_LIST_ID = NAMESPACE + ".countUserList";
    private static final String GET_MAX_USER_ID_ID = NAMESPACE + ".getMaxUserId";
    private static final String GET_MIN_USER_ID_ID = NAMESPACE + ".getMinUserId";
    private static final String SCAN_USER_LIST_ID = NAMESPACE + ".scanUserList";
    private static final String QUERY_USER_ID = NAMESPACE + ".queryUser";

    private final SqlSessionTemplate sqlSessionTemplate;

    public UserDAOImpl(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int insetUser(UserDO userDO) {
        return sqlSessionTemplate.insert(INSET_USER_ID, userDO);
    }

    @Override
    public UserDO queryUser(Long id) {
        return sqlSessionTemplate.selectOne(QUERY_USER_ID, id);
    }

    @Override
    public List<UserDO> queryUserList(QueryUserListDAOParam param, int skip, int limit) {
        Map<String, Object> map = new HashMap<>(8);
        map.put("param", param);
        map.put("skip", skip);
        map.put("limit", limit);
        return sqlSessionTemplate.selectList(QUERY_USER_LIST_ID, map);
    }

    @Override
    public int countUserList(QueryUserListDAOParam param) {
        return sqlSessionTemplate.selectOne(COUNT_USER_LIST_ID, param);
    }

    @Override
    public long getMaxUserId(QueryUserListDAOParam param) {
        return sqlSessionTemplate.selectOne(GET_MAX_USER_ID_ID, param);
    }

    @Override

    public long getMinUserId(QueryUserListDAOParam param) {
        return sqlSessionTemplate.selectOne(GET_MIN_USER_ID_ID, param);
    }

    @Override
    public List<UserDO> scanUserList(Long startIncludeId, Long endExcludeId) {
        Map<String, Object> map = new HashMap<>(4);
        map.put("startIncludeId", startIncludeId);
        map.put("endExcludeId", endExcludeId);
        return sqlSessionTemplate.selectList(SCAN_USER_LIST_ID, map);
    }
}
