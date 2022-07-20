package com.gzl.base.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gzl.base.entity.Dictionary;
import com.gzl.base.mapper.DictionaryMapper;
import com.gzl.base.service.DictionaryService;
import com.gzl.common.model.base.dictionary.DictionaryRequest;
import com.gzl.common.model.base.dictionary.DictionaryResponse;
import com.gzl.common.model.base.dictionary.SearchDictionaryRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gzl
 * @since 2022-07-20
 */
@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements DictionaryService {

    @Resource
    private DictionaryMapper dictionaryMapper;

    @Override
    public void insertDictionary(List<DictionaryRequest> dictionaryRequests) {
        dictionaryMapper.insertDictionary(dictionaryRequests);
    }

    @Override
    public void deleteDictionary(List<DictionaryRequest> dictionaryRequests) {

        dictionaryMapper.deleteDictionary(dictionaryRequests);
    }

    @Override
    public void updateDictionary(DictionaryRequest dictionaryRequest) {
        dictionaryMapper.updateDictionary(dictionaryRequest);
    }

    @Override
    public List<DictionaryResponse> selectDictionaryCondition(SearchDictionaryRequest searchDictionaryRequest) {
        return dictionaryMapper.selectDictionaryCondition(searchDictionaryRequest);
    }
}
