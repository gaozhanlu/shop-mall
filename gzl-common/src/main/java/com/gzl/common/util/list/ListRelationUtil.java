package com.gzl.common.util.list;

import com.google.common.collect.Maps;
import com.gzl.common.error.ApiException;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ListRelationUtil {

    /**
     * 将javaBean组成的list去重 转为map, key为bean中指定的一个属性
     * (已经废弃,推荐使用泛型方法)
     *
     * @param beanList list 本身
     * @param keyName 生成的map中的key
     * @return
     * @throws Exception
     */
    @Deprecated
    public static Map<String, Object> beanListToMap(List beanList, String keyName) {
        //:::创建一个map
        Map<String, Object> map = Maps.newHashMap();

        //:::由keyName获得对应的get方法字符串
        String getMethodName = makeGetMethodName(keyName);

        try {
            //:::遍历beanList
            for (Object obj : beanList) {

                //:::获得get方法
                Method getMethod = obj.getClass().getMethod(getMethodName);

                //:::通过get方法从bean对象中得到数据key
                String result = (String) getMethod.invoke(obj);

                //:::放入map中(如果key一样,则会被覆盖去重)
                map.put(result, obj);
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }

        //:::返回结果
        return map;
    }

    /**
     * 将javaBean组成的list去重 转为map, key为bean中指定的一个属性
     *
     * @param beanList list 本身
     * @param keyName 生成的map中的key
     * @return
     * @throws Exception
     */
    public static <T> Map<String, T> beanListToMapGeneric(List<T> beanList, String keyName) throws ApiException {
        //:::创建一个map
        Map<String, T> map = Maps.newHashMap();

        //:::由keyName获得对应的get方法字符串
        String getMethodName = makeGetMethodName(keyName);

        try {
            //:::遍历beanList
            for (T obj : beanList) {

                //:::获得get方法
                Method getMethod = obj.getClass().getMethod(getMethodName);

                //:::通过get方法从bean对象中得到数据key
                String result = (String) getMethod.invoke(obj);

                //:::放入map中(如果key一样,则会被覆盖去重)
                map.put(result, obj);
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }

        //:::返回结果
        return map;
    }

    /**
     * 将列表转换成以某一个字段作为key,字段值相同的存放在一个list之中的map
     * @param beanList      列表数据
     * @param keyName       作为key的字段名
     * @return keyName字段名对应的字段值相同的放在为一个List的map
     * @throws ApiException
     */
    public static <T> Map<String, List<T>> listToListMap(List<T> beanList, String keyName) throws ApiException {
        Map<String, List<T>> listMap = Maps.newHashMap();
        try {
            //:::遍历beanList
            for (T beanItem : beanList) {
                //::: keyName字段对应的值
                String keyValue;
                if (beanItem instanceof Map) {
                    //:::如果当前bean是map,获得keyName字段对应的值
                    keyValue = ((Map) beanItem).get(keyName).toString();
                } else {
                    //:::否则默认,当前bean是POJO

                    //:::获得,并且调用get方法,获得keyName字段对应的值
                    String getMethodName = makeGetMethodName(keyName);
                    Method getMethod = beanItem.getClass().getMethod(getMethodName);
                    keyValue = getMethod.invoke(beanItem).toString();
                }

                //:::通过 keyName字段对应的值获得对应的列表
                List<T> list = listMap.get(keyValue);
                //:::如果列表为空
                if (list == null) {
                    //:::新建一个列表
                    List<T> newList = new ArrayList<>();
                    //:::当前beanItem加入新的列表
                    newList.add(beanItem);
                    //:::存入listMap
                    listMap.put(keyValue, newList);
                } else {
                    //:::直接加入之前的列表之中
                    list.add(beanItem);
                }
            }
        } catch (NoSuchMethodException e) {
//            logger.info(e.getMessage());
            throw new ApiException("keyName对应的无参get方法 找不到", e);
        } catch (InvocationTargetException e) {
//            logger.info(e.getMessage());
            throw new ApiException("keyName对应的无参get方法 执行失败", e);
        } catch (IllegalAccessException e) {
//            logger.info(e.getMessage());
            throw new ApiException("keyName对应的无参get方法 不是public的", e);
        }

        return listMap;
    }

    /**
     * 将map对象组成的list去重 转为map, key由参数指定
     *
     * @param list
     * @param keyName
     * @return
     */
    public static Map<String, Object> mapListToMap(List<Map<String, Object>> list, String keyName) {
        Map<String, Object> map = Maps.newHashMap();

        for (Map<String, Object> currentMap : list) {
            String result = (String) currentMap.get(keyName);
            map.put(result, currentMap);
        }

        return map;
    }

    /**
     * 将某种类型的对象列表转为另一种对象的列表
     * */
    public static <T, E> List<T> getListConvertType(List<E> sourceDataList, Class<T> clazz) throws ApiException {
        List<T> newDataList = new ArrayList<>(sourceDataList.size());

        try {
            for (E sourceData : sourceDataList) {
                if (sourceData != null) {
                    T newData = clazz.newInstance();
                    org.springframework.beans.BeanUtils.copyProperties(sourceData, newData);
                    newDataList.add(newData);
                }
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
        return newDataList;
    }

    /**
     * 从pojo对象组成的list之中获得某一项的数据集合(用于批量查询获取idList)
     * */
    public static List<String> getKeyListFromBeanList(List beanList, String keyName) throws ApiException {
        Set<String> set = new HashSet<>();

        String getMethodName = makeGetMethodName(keyName);

        try {
            //:::遍历beanList
            for (Object obj : beanList) {
                //:::获得get方法
                Method getMethod = obj.getClass().getMethod(getMethodName);

                //:::通过get方法从bean对象中得到数据key
                String result = (String) getMethod.invoke(obj);

                //:::放入set中(去重)
                set.add(result);
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }

        //:::将set转为list返回
        return new ArrayList<>(set);
    }

    /**
     * 从map对象组成的list之中获得某一项的数据集合(用于批量查询获取idList)
     * */
    public static List<String> getKeyListFromMapList(List<Map> beanList, String keyName) throws ApiException {
        Set<String> set = new HashSet<>();

        //:::遍历mapList
        for (Map map : beanList) {
            String result = (String) map.get(keyName);

            //:::放入set中(去重)
            set.add(result);
        }

        //:::将set转为list返回
        return new ArrayList<>(set);
    }

    /**
     * 从pojo对象组成的数组之中获得某一项的数据集合(用于批量查询获取idList)
     * */
    public static List<String> getKeyListFromArray(Object[] beanArray, String keyName) throws ApiException {
        //:::将数组转成list
        List beanList = Arrays.asList(beanArray);

        return getKeyListFromBeanList(beanList, keyName);
    }

    /**
     * 将批量查询出来的 'map类型' 数据集合,组装到对应的beanList之中(详情请见最下面的demo)
     * 一对一连接
     * @param beanList 需要被存放数据的beanList(主体)
     * @param beanKeyName   beanList中用来匹配数据的属性
     * @param beanModelName  beanList中用来存放匹配到的数据的属性
     * @param dataList  被批量查询出来的data结果集（内部裝的是map）
     * @param dataKeyName 被批量查询出来的data中的key,和参数beanKeyName代表的数值一致
     * @throws ApiException
     */
    public static void oneToOneLinkedWithMap(List beanList, String beanKeyName, String beanModelName, List<Map<String, Object>> dataList,
                                             String dataKeyName) throws ApiException {
        //:::如果不需要转换,直接返回
        if (!needTrans(beanList, dataList)) {
            return;
        }

        //:::将需要被组装的数据转成map,方便查询
        Map<String, Object> dataMap = mapListToMap(dataList, dataKeyName);

        //:::将数据对象转入
        matchedDataToBeanList(beanList, beanKeyName, beanModelName, dataMap);
    }

    /**
     * 将批量查询出来的 'pojo类型' 数据集合,组装到对应的beanList之中(详情请见最下面的demo)
     * 一对一连接
     * @param beanList 需要被存放数据的beanList(主体)
     * @param beanKeyName   beanList中用来匹配数据的属性
     * @param beanModelName  beanList中用来存放匹配到的数据的属性
     * @param dataList  被批量查询出来的data结果集（内部裝的是bean）
     * @param dataKeyName 被批量查询出来的data中的key,和参数beanKeyName代表的数值一致
     * @throws ApiException
     */
    public static void oneToOneLinked(List beanList, String beanKeyName, String beanModelName, List dataList, String dataKeyName)
            throws ApiException {
        //:::如果不需要转换,直接返回
        boolean flag = needTrans(beanList, dataList);
        if (!flag) {
            return;
        }

        //:::将需要被组装的数据转成map,方便查询
        Map<String, Object> dataMap = beanListToMap(dataList, dataKeyName);

        //:::将数据对象转入
        matchedDataToBeanList(beanList, beanKeyName, beanModelName, dataMap);
    }

    /**
     * 数据列表 一对多连接 :  oneKeyName <---> manyKeyName 作为连接条件
     *
     * @param oneDataList       '一方' 数据列表
     * @param oneKeyName        '一方' 连接字段key的名字
     * @param oneModelName      '一方' 用于存放 '多方'数据的列表属性名
     * @param manyDataList      '多方' 数据列表
     * @param manyKeyName       '多方' 连接字段key的名字
     *
     *  潜规则:    '一方' 存放 '多方'数据的属性类型必须为List
     *
     * @throws ApiException
     */
    public static <T,R> void oneToManyLinked(List<T> oneDataList, String oneKeyName, String oneModelName, List<R> manyDataList, String manyKeyName)
            throws ApiException {
        if (!needTrans(oneDataList, manyDataList)) {
            return;
        }

        //:::将'一方'数据,以连接字段为key,转成map,便于查询
        Map<String, T> oneDataMap = beanListToMapGeneric(oneDataList, oneKeyName);

        //:::获得'一方'存放 '多方'数据字段的get方法名
        String oneDataModelGetMethodName = makeGetMethodName(oneModelName);
        //:::获得'一方'存放 '多方'数据字段的set方法名
        String oneDataModelSetMethodName = makeSetMethodName(oneModelName);

        //:::获得'多方'连接字段的get方法名
        String manyDataKeyGetMethodName = makeGetMethodName(manyKeyName);

        try {
            //:::遍历;多方'列表
            for (R manyDataItem : manyDataList) {
                //:::多方对象连接key的值
                String manyDataItemKey;

                //:::判断当前'多方'对象的类型是否是 hashMap
                if (manyDataItem.getClass() == HashMap.class) {
                    //:::如果是hashMap类型的,先转为Map对象
                    Map<String, R> manyDataItemMap = (Map<String, R>) manyDataItem;

                    //:::通过参数key 直接获取对象key连接字段的值
                    manyDataItemKey = (String) manyDataItemMap.get(manyKeyName);
                } else {
                    //:::如果是普通的pojo对象,则通过反射获得get方法来获取key连接字段的值

                    //:::获得 '多方' 数据中key的method对象
                    Method manyDataKeyGetMethod = manyDataItem.getClass().getMethod(manyDataKeyGetMethodName);

                    //:::调用'多方'数据的get方法获得当前 '多方' 数据连接字段key的值
                    manyDataItemKey = (String) manyDataKeyGetMethod.invoke(manyDataItem);
                }

                //:::通过'多方'的连接字段key从 '一方' map集合中查找出连接key相同的 '一方'数据对象
                Object matchedOneData = oneDataMap.get(manyDataItemKey);

                //:::如果匹配到了数据,才进行操作
                if (matchedOneData != null) {
                    //:::将当前迭代的 '多方'数据 放入 '一方' 的对应的列表中
                    setManyDataToOne(matchedOneData, manyDataItem, oneDataModelGetMethodName, oneDataModelSetMethodName);
                }
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    /**
     * 当确保查询出的list只有一条数据时,转换的接口
     * */
    public static <T> T getUniqueData(List<T> beanList) throws ApiException {
        if (beanList.isEmpty()) {
            //:::如果查询出的list为空
            return null;
        } else if (beanList.size() == 1) {
            //:::恰好只有一个
            return beanList.get(0);
        } else {
            //:::多于一个,抛异常
            throw new ApiException("查询到多条符合要求的记录");
        }
    }

    /**
     * 将map列表转成对象列表
     * */
    public static List transMapListToBeanList(List<Map<String, Object>> mapList, Class clazz) throws ApiException {
        List beanList = new ArrayList<>();

        try {
            for (Map<String, Object> map : mapList) {

                Object obj = clazz.newInstance();

                BeanUtils.populate(obj, map);

                beanList.add(obj);
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }

        return beanList;
    }

    /**
     * 将对象列表转成map列表
     * */
    public static List<Map<String,Object>> transBeanListToMapList(List beanList) throws ApiException {
        try {
            List<Map<String,Object>> mapList = new ArrayList<>();
            for(Object item : beanList){
                Map itemMap = BeanUtils.describe(item);
                mapList.add(itemMap);
            }

            return mapList;
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }


    //===========================================辅助方法=======================================================

    /***
     * 将通过keyName获得对应的bean对象的get方法名称的字符串
     * @param keyName 属性名
     * @return 返回get方法名称的字符串
     */
    private static String makeGetMethodName(String keyName) {
        //:::将第一个字母转为大写
        String newKeyName = transFirstCharUpperCase(keyName);

        String getMethodName = "get" + newKeyName;

        return getMethodName;
    }

    /***
     * 将通过keyName获得对应的bean对象的set方法名称的字符串
     * @param keyName 属性名
     * @return 返回set方法名称的字符串
     */
    private static String makeSetMethodName(String keyName) {
        //:::将第一个字母转为大写
        String newKeyName = transFirstCharUpperCase(keyName);

        String setMethodName = "set" + newKeyName;

        return setMethodName;
    }

    /**
     * 判断当前的数据是否需要被转换
     *
     * 两个列表存在一个为空,则不需要转换
     * @return 不需要转换返回 false,需要返回 true
     * */
    private static boolean needTrans(List beanList, List dataList) {
        if (listIsEmpty(beanList) || listIsEmpty(dataList)) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean listIsEmpty(List list) {
        if (list == null || list.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 将批量查询出来的数据集合,组装到对应的beanList之中
     * @param beanList 需要被存放数据的beanList(主体)
     * @param beanKeyName   beanList中用来匹配数据的属性
     * @param beanModelName  beanList中用来存放匹配到的数据的属性
     * @param dataMap  data结果集以某一字段作为key对应的map
     * @throws ApiException
     */
    private static void matchedDataToBeanList(List beanList, String beanKeyName, String beanModelName, Map<String, Object> dataMap)
            throws ApiException {
        //:::获得beanList中存放对象的key的get方法名
        String beanGetMethodName = makeGetMethodName(beanKeyName);

        //:::获得beanList中存放对象的model的set方法名
        String beanSetMethodName = makeSetMethodName(beanModelName);

        try {
            //:::遍历整个beanList
            for (Object bean : beanList) {
                //:::获得bean中key的method对象
                Method beanGetMethod = bean.getClass().getMethod(beanGetMethodName);

                //:::调用获得当前的key
                String currentBeanKey = (String) beanGetMethod.invoke(bean);

                //:::从批量查询出来的数据集中找到匹配的数据
                Object matchedData = dataMap.get(currentBeanKey);

                //:::如果找到了匹配的对象
                if (matchedData != null) {
                    //:::获得bean中对应model的set方法
                    Class clazz = matchedData.getClass();

                    //:::暂时不知道怎么解决,打个补丁
                    if (clazz == HashMap.class) {
                        //:::转为父类map class用来调用set方法
                        clazz = Map.class;
                    }

                    Method beanSetMethod = bean.getClass().getMethod(beanSetMethodName, clazz);

                    //:::执行set方法,将匹配到的数据放入model中
                    beanSetMethod.invoke(bean, matchedData);
                }
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    /**
     * 将字符串的第一个字母转为大写
     * @param str 需要被转变的字符串
     * @return 返回转变之后的字符串
     */
    private static String transFirstCharUpperCase(String str) {
        return str.replaceFirst(str.substring(0, 1), str.substring(0, 1).toUpperCase());
    }

    /**
     * 将 '多方' 数据存入 '一方' 列表中
     * @param oneData 匹配到的'一方'数据
     * @param manyDataItem  当前迭代的 '多方数据'
     * @param oneDataModelGetMethodName 一方列表的get方法名
     * @param oneDataModelSetMethodName 一方列表的set方法名
     * @throws Exception
     */
    private static void setManyDataToOne(Object oneData, Object manyDataItem, String oneDataModelGetMethodName,
                                         String oneDataModelSetMethodName) throws Exception {
        //:::获得 '一方' 数据中存放'多方'数据属性的get方法
        Method oneDataModelGetMethod = oneData.getClass().getMethod(oneDataModelGetMethodName);

        //::: '一方' 数据中存放'多方'数据属性的set方法
        Method oneDataModelSetMethod;
        try {
            //::: '一方' set方法对象
            oneDataModelSetMethod = oneData.getClass().getMethod(oneDataModelSetMethodName, List.class);
        } catch (NoSuchMethodException e) {
            throw new ApiException("一对多连接时,一方指定的model对象必须是list类型");
        }

        //:::获得存放'多方'数据get方法返回值类型
        Class modelType = oneDataModelGetMethod.getReturnType();

        //::: get方法返回值必须是List
        if (modelType.equals(List.class)) {
            //:::调用get方法,获得数据列表
            List modelList = (List) oneDataModelGetMethod.invoke(oneData);

            //:::如果当前成员变量为null
            if (modelList == null) {
                //:::创建一个新的List
                List newList = new ArrayList<>();

                //:::将当前的'多方'数据存入list
                newList.add(manyDataItem);

                //:::将这个新创建出的List赋值给 '一方'的对象
                oneDataModelSetMethod.invoke(oneData, newList);
            } else {
                //:::如果已经存在了List

                //:::直接将'多方'数据存入list
                modelList.add(manyDataItem);
            }

        } else {
            throw new ApiException("一对多连接时,一方指定的model对象必须是list类型");
        }
    }

//    public static void main(String[] args) throws ApiException{
//        /**
//         * 举例说明
//         * class Home{
//         *     String id;
//         *     String address;
//         * }
//         *
//         * class Student{
//         *     String id;
//         *     String homeId;
//         *     Home home;
//         * }
//         * */
//
//        Home h1 = new Home("11111","一栋101");
//        Home h2 = new Home("22222","一栋102");
//        Home h3 = new Home("33333","一栋103");
//
//        List<Home> homeList = new ArrayList<>();
//        homeList.add(h1);
//        homeList.add(h2);
//        homeList.add(h3);
//
//        Student s1 = new Student("001","33333");
//        Student s2 = new Student("002","22222");
//        Student s3 = new Student("003","11111");
//
//        List<Student> studentList = new ArrayList<>();
//        studentList.add(s1);
//        studentList.add(s2);
//        studentList.add(s3);
//
//        //:::将homeList中的数据组装进studentList中对应的bean中
//        oneToOneLinked(studentList,"homeId","home",homeList,"id");
//    }
}
