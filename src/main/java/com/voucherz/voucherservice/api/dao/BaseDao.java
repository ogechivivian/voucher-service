package com.voucherz.voucherservice.api.dao;

import java.util.List;

public interface BaseDao<T> {
    public T create(T Model);
    public boolean update(T model);
    public T find (long id);
    public List<T> findAll();
    public boolean delete(T model);
    public boolean updatestatus(String code);

}
