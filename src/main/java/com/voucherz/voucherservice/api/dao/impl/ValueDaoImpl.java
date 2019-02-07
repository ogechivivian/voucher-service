package com.voucherz.voucherservice.api.dao.impl;

import com.voucherz.voucherservice.api.dao.AbstractBaseDao;
import com.voucherz.voucherservice.api.dao.ValueDao;
import com.voucherz.voucherservice.api.dao.util.RowCountMapper;
import com.voucherz.voucherservice.api.model.Discount;
import com.voucherz.voucherservice.api.model.Gift;
import com.voucherz.voucherservice.api.model.Value;
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
public class ValueDaoImpl extends AbstractBaseDao<Value> implements ValueDao{
    protected SimpleJdbcCall findByCode;
    protected SimpleJdbcCall findByValueType;
    protected SimpleJdbcCall findByValueCode;

    @Autowired
    @Override
    public void setDataSource(@Qualifier(value = "dataSource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        create = new SimpleJdbcCall(dataSource).withProcedureName("CreateValueVoucher").withReturnValue();
        update = new SimpleJdbcCall(jdbcTemplate).withProcedureName("UpdateValueVoucher").withReturnValue();
        find = new SimpleJdbcCall(jdbcTemplate).withProcedureName("find_agent")
                .returningResultSet(SINGLE_RESULT, new BeanPropertyRowMapper<>(Discount.class));
        findAll = new SimpleJdbcCall(jdbcTemplate).withProcedureName("find_all_agents").returningResultSet(RESULT_COUNT, new RowCountMapper())
                .returningResultSet(MULTIPLE_RESULT, new BeanPropertyRowMapper<>(Discount.class));
        findByCode = new SimpleJdbcCall(jdbcTemplate).withProcedureName("find_agent_by_code")
                .returningResultSet(SINGLE_RESULT, new BeanPropertyRowMapper<>(Discount.class));
        findByValueType = new SimpleJdbcCall(jdbcTemplate).withProcedureName("findAllValueVoucher")
                .returningResultSet(MULTIPLE_RESULT, new BeanPropertyRowMapper<>(Gift.class));
        findByValueCode = new SimpleJdbcCall(jdbcTemplate).withProcedureName("findValueVoucherByCode")
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

    public Discount findByCode(String agentCode) {
        SqlParameterSource in = new MapSqlParameterSource().addValue("code", agentCode);
        Map<String, Object> m = findByCode.execute(in);
        List<Discount> list = (List<Discount>) m.get(SINGLE_RESULT);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }


    @Override
    public List<Value> findByValueType(String valueType) {
        SqlParameterSource in = new MapSqlParameterSource().addValue("ValueType",valueType);
        Map<String, Object> m =findByValueType.execute(in);
        List<Value> list  = (List<Value>) m.get(MULTIPLE_RESULT);
        if(list == null || list.isEmpty()){
            return null;
        }
        return list;
    }

    public Value findByValueCode(String valueCode) {
        SqlParameterSource in = new MapSqlParameterSource().addValue("code", valueCode);
        Map<String, Object> m = findByValueCode.execute(in);
        List<Value> list = (List<Value>) m.get(SINGLE_RESULT);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
