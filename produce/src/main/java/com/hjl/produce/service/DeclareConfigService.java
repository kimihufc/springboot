package com.hjl.produce.service;

import com.hjl.produce.dao.DeclareConfig;

import java.util.List;

/**
 * Created   on 2018/10/13.
 *
 * @author hjl
 */
public interface DeclareConfigService {
    List<DeclareConfig> selectAllDeclareConfig();
}
