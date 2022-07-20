package com.gzl.base.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gzl.base.entity.Dictionary;
import com.gzl.common.model.base.dictionary.DictionaryRequest;
import com.gzl.common.model.base.dictionary.DictionaryResponse;
import com.gzl.common.model.base.dictionary.SearchDictionaryRequest;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gzl
 * @since 2022-07-20
 */
public interface DictionaryService extends IService<Dictionary> {

    void insertDictionary(List<DictionaryRequest> dictionaryRequests);

    void deleteDictionary(List<DictionaryRequest> dictionaryRequests);

    void updateDictionary(DictionaryRequest dictionaryRequest);

    List<DictionaryResponse> selectDictionaryCondition(SearchDictionaryRequest searchDictionaryRequest);
}
