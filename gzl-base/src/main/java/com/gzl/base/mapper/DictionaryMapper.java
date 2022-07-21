package com.gzl.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gzl.base.entity.Dictionary;
import com.gzl.common.model.base.dictionary.DictionaryRequest;
import com.gzl.common.model.base.dictionary.DictionaryResponse;
import com.gzl.common.model.base.dictionary.SearchDictionaryRequest;
import org.apache.ibatis.annotations.Mapper;

import javax.mail.MailSessionDefinition;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gzl
 * @since 2022-07-20
 */

@Mapper
public interface DictionaryMapper extends BaseMapper<Dictionary> {

    List<DictionaryResponse> selectDictionaryCondition(SearchDictionaryRequest searchDictionaryRequest);

    void updateDictionary(DictionaryRequest dictionaryRequest);

    void deleteDictionary(List<DictionaryRequest> dictionaryRequests);

    void insertDictionary(List<DictionaryRequest> dictionaryRequests);
}
