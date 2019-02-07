package com.voucherz.voucherservice.api.dao.impl;

import com.voucherz.voucherservice.api.dao.AbstractBaseDao;
import com.voucherz.voucherservice.api.dao.RedeemptionDao;
import com.voucherz.voucherservice.api.dao.util.RowCountMapper;
import com.voucherz.voucherservice.api.model.Redeemption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
@Repository
public class RedeemptionDaoImpl extends AbstractBaseDao<Redeemption> implements RedeemptionDao {
    protected SimpleJdbcCall findByCode;

    @Autowired
    @Override
    public void setDataSource(@Qualifier(value = "dataSource") DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        create = new SimpleJdbcCall(dataSource).withProcedureName("CreateDiscountVoucher").withReturnValue();
        update = new SimpleJdbcCall(jdbcTemplate).withProcedureName("").withReturnValue();
        find = new SimpleJdbcCall(jdbcTemplate).withProcedureName("find_agent")
            .returningResultSet(SINGLE_RESULT, new BeanPropertyRowMapper<>(Redeemption.class));
        findAll = new SimpleJdbcCall(jdbcTemplate).withProcedureName("find_all_agents").returningResultSet(RESULT_COUNT, new RowCountMapper())
            .returningResultSet(MULTIPLE_RESULT, new BeanPropertyRowMapper<>(Redeemption.class));
        findByCode = new SimpleJdbcCall(jdbcTemplate).withProcedureName("find_agent_by_code")
            .returningResultSet(SINGLE_RESULT, new BeanPropertyRowMapper<>(Redeemption.class));
//        findByDiscountType = new SimpleJdbcCall(jdbcTemplate).withProcedureName("findVoucherByDisocunt")
//            .returningResultSet(MULTIPLE_RESULT, new BeanPropertyRowMapper<>(Discount.class));
//        findByDiscountCode = new SimpleJdbcCall(jdbcTemplate).withProcedureName("findDiscountVoucherByCode")
//            .returningResultSet(SINGLE_RESULT, new BeanPropertyRowMapper<>(Discount.class));
//        findAllDiscountType = new SimpleJdbcCall(jdbcTemplate).withProcedureName("findByVoucherType")
//                .returningResultSet(MULTIPLE_RESULT, new BeanPropertyRowMapper<>(Discount.class));
    }

}
