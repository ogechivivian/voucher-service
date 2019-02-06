package com.voucherz.voucherservice.api.dao.impl;

import com.voucherz.voucherservice.api.dao.AbstractBaseDao;
import com.voucherz.voucherservice.api.dao.GiftDao;
import com.voucherz.voucherservice.api.dao.util.RowCountMapper;
import com.voucherz.voucherservice.api.model.Gift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class GiftDaoImpl extends AbstractBaseDao<Gift> implements  GiftDao{
    protected SimpleJdbcCall findByCode;
    protected SimpleJdbcCall findByGiftType;
    protected SimpleJdbcCall findByGiftCode;

    @Autowired
    @Override
    public void setDataSource(@Qualifier(value = "dataSource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        create = new SimpleJdbcCall(dataSource).withProcedureName("CreateGiftVoucher").withReturnValue();
        update = new SimpleJdbcCall(jdbcTemplate).withProcedureName("UpdateGiftVoucher").withReturnValue();
        find = new SimpleJdbcCall(jdbcTemplate).withProcedureName("find_agent")
                .returningResultSet(SINGLE_RESULT, new BeanPropertyRowMapper<>(Gift.class));
        findAll = new SimpleJdbcCall(jdbcTemplate).withProcedureName("find_all_agents").returningResultSet(RESULT_COUNT, new RowCountMapper())
                .returningResultSet(MULTIPLE_RESULT, new BeanPropertyRowMapper<>(Gift.class));
        findByCode = new SimpleJdbcCall(jdbcTemplate).withProcedureName("find_agent_by_code")
                .returningResultSet(SINGLE_RESULT, new BeanPropertyRowMapper<>(Gift.class));
        findByGiftType = new SimpleJdbcCall(jdbcTemplate).withProcedureName("findAllGiftVoucher")
                .returningResultSet(MULTIPLE_RESULT, new BeanPropertyRowMapper<>(Gift.class));
        findByGiftCode = new SimpleJdbcCall(jdbcTemplate).withProcedureName("findGiftVoucherByCode")
                .returningResultSet(SINGLE_RESULT, new BeanPropertyRowMapper<>(Gift.class));
    }

//    @Autowired
//    @Override
//    public void setReadOnlyDataSource(@Qualifier(value = "readOnlyDataSource") DataSource dataSource) {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        find = new SimpleJdbcCall(jdbcTemplate).withProcedureName("find_agent")
//                .returningResultSet(SINGLE_RESULT, new BeanPropertyRowMapper<>(Agent.class));
//        findAll = new SimpleJdbcCall(jdbcTemplate).withProcedureName("find_all_agents").returningResultSet(RESULT_COUNT, new RowCountMapper())
//                .returningResultSet(MULTIPLE_RESULT, new BeanPropertyRowMapper<>(Agent.class));
//    }

    public Gift findByCode(String agentCode) {
        SqlParameterSource in = new MapSqlParameterSource().addValue("code", agentCode);
        Map<String, Object> m = findByCode.execute(in);
        List<Gift> list = (List<Gift>) m.get(SINGLE_RESULT);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<Gift> findByGiftType(String giftType){
        SqlParameterSource in = new MapSqlParameterSource().addValue("GiftType",giftType);
        Map<String, Object> m =findByGiftType.execute(in);
        List<Gift> list  = (List<Gift>) m.get(MULTIPLE_RESULT);
        if(list == null || list.isEmpty()){
            return null;
        }
        return list;
    }
    public Gift findByGiftCode(String giftCode) {
        SqlParameterSource in = new MapSqlParameterSource().addValue("code", giftCode);
        Map<String, Object> m = findByGiftCode.execute(in);
        List<Gift> list = (List<Gift>) m.get(SINGLE_RESULT);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}
