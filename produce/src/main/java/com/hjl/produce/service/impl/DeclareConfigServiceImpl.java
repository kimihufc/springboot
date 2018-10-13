package com.hjl.produce.service.impl;

import com.hjl.produce.dao.DeclareConfig;
import com.hjl.produce.mapper.DeclareConfigMapper;
import com.hjl.produce.service.DeclareConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created   on 2018/10/13.
 *
 * @author hjl
 */
@Service
public class DeclareConfigServiceImpl implements DeclareConfigService {

    @Autowired
    private DeclareConfigMapper declareConfigMapper;

    @Override
    public List<DeclareConfig> selectAllDeclareConfig() {
        return declareConfigMapper.selectAllDeclareConfig();
    }
}
