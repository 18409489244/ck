package com.lyf.poi.list.util;

/**
 * 通用常量信息
 *
 *
 */
public class Constants
{
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";

    /**
     * www主域
     */
    public static final String WWW = "www.";

    /**
     * RMI 远程方法调用
     */
    public static final String LOOKUP_RMI = "rmi:";

    /**
     * LDAP 远程方法调用
     */
    public static final String LOOKUP_LDAP = "ldap:";

    /**
     * LDAPS 远程方法调用
     */
    public static final String LOOKUP_LDAPS = "ldaps:";

    /**
     * http请求
     */
    public static final String HTTP = "http://";

    /**
     * https请求
     */
    public static final String HTTPS = "https://";

    /**
     * 成功标记
     */
    public static final Integer SUCCESS = 200;

    /**
     * 失败标记
     */
    public static final Integer FAIL = 500;

    /**
     * 登录成功状态
     */
    public static final String LOGIN_SUCCESS_STATUS = "0";

    /**
     * 登录失败状态
     */
    public static final String LOGIN_FAIL_STATUS = "1";

    /**
     * 禁用 | 未发布 | 未计算...
     */
    public static final String STATE_ZERO = "0";

    /**
     * 启用 | 已发布 | 已计算
     */
    public static final String STATE_ONE = "1";
    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 注册
     */
    public static final String REGISTER = "Register";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 当前记录起始索引
     */
    public static final String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static final String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static final String IS_ASC = "isAsc";

    /**
     * 验证码有效期（分钟）
     */
    public static final long CAPTCHA_EXPIRATION = 2;

    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";

    /**
     * 自动识别json对象白名单配置（仅允许解析的包名，范围越小越安全）
     */
    public static final String[] JSON_WHITELIST_STR = { "org.springframework", "com.cmict" };

    /**
     * 定时任务白名单配置（仅允许访问的包名，如其他需要可以自行添加）
     */
    public static final String[] JOB_WHITELIST_STR = { "com.cmict" };

    /**
     * 定时任务违规的字符
     */
    public static final String[] JOB_ERROR_STR = { "java.net.URL", "javax.naming.InitialContext", "org.yaml.snakeyaml",
            "org.springframework", "org.apache", "com.cmict.common.core.utils.file" };

    /**
     * 满意度考核项
     */
    public static final String IOC_ASSESS_TYPE_SATISFACT = "satisfact";
    /**
     * 指标体系考核项
     */
    public static final String IOC_ASSESS_TYPE_INDEX = "index";

    /**
     * 定性
     */
    public static final String ATTR_NUMBER_ONE = "1";
    /**
     * 定量
     */
    public static final String ATTR_NUMBER_TWO = "2";
    /**
     * 需求时间范围类型
     */
    public static final String REQUIREMENT_TIME_RANGE_TYPE = "requirement_time_range_type";
    // 需求类型
    public static final String IOC_DICT_REQUIREMENT_TYPE = "requirement_type";
    // 需求时间范围
    public static final String IOC_DICT_REQUIREMENT_TIME_RANGE_TIME = "requirement_time_range_type";
    // 需求状态
    public static final String IOC_DICT_REQUIREMENT_STATE = "requirement_state";
    //时间维度
    public static final String IOC_DICT_TIME_DIM = "ioc_time_dim";
    //空间维度
    public static final String IOC_DICT_SPACE_DIM = "ioc_space_dim";
    //数据获取方式
    public static final String IOC_DICT_DATA_GET_TYPE = "ioc_data_get_type";
    //统计周期
    public static final String IOC_DICT_STATISTICAL_CYCLE = "ioc_statistical_cycle";
    //对接方式
    public static final String IOC_DICT_DOCKING_METHOD = "ioc_docking_method";
    //频次
    public static final String IOC_DICT_FREQUENCY = "ioc_frequency";
    //单位
    public static final String IOC_DICT_UNIT = "ioc_unit";
    //数据来源
    public static final String IOC_DICT_DATA_SOURCE = "ioc_data_source";
    //数据类型
    public static final String IOC_DICT_DATA_TYPE = "ioc_data_type";
    //指标类别
    public static final String IOC_INDEX_TYPE = "ioc_index_type";
    //通用字典：值为1：是、0：否
    public static final String IOC_IS = "ioc_is";
    //标签类型
    public static final String IOC_TAG_TYPE = "ioc_tag_type";
    //区域类型
    public static final String IOC_REGION_TYPE = "ioc_region_type";
    //指标体系
    public static final String IOC_APPLY_RANGE = "ioc_apply_range";
    //中国
    public static final String CHINA_REGION = "china_region";
    //年份
    public static final String IOC_KHPGXT_YEAR = "ioc_khpgxt_year";
    // 区划发展状态：发达 中等发达 一般发达
    public static final String IOC_DEVELOP_STATE = "ioc_develop_state";
    //政策类型：条例、行动方案
    public static final String IOC_POLICY_TYPE = "ioc_policy_type";
    //数据获取方式
    public static final String DATA_GET_TYPE_DATA_FILL = "data_fill";
    //数据获取方式
    public static final String DATA_GET_TYPE_DATA_INDEX = "index";
    //指标关联考核项
    public static final String REL_ID_TYPE_INDEX = "3";
    //一级层级关联考核项
    public static final String REL_ID_TYPE_LEVEL= "2";
    //考核体系关联考核项
    public static final String REL_ID_TYPE_ASSESS= "1";
    /**
     * 部门简称
     */
    public static final String IOC_DEPT_SHORT_NAME= "ioc_dept_short_name";
    public static final String GOVERNMENT_POST= "政府部门";
    public static final String INNER_POST= "内部部门";

    /**
     * 主观评测类
     */
    public static final String SUBJECTIVITY= "subjectivity";
    /**
     * 政府填报类
     */
    public static final String FILLING= "filling";



    //企业问卷
    public static final String ENTERPRISE = "enterprise";
    //政府填报
    public static final String GOVERNMENT = "government";
    //定性
    public static final String DX = "qualitative";
    //定量
    public static final String DL = "quantitative";

    //一级层级
    public static final String ONELEVEL = "oneLevel";
    //二级层级
    public static final String TWOLEVEL = "twoLevel";
    //指标名称
    public static final String INDEXNAME = "indexName";
    // 权重关联类型：全局考核项
    public static final String WEIGHT_REL_GLOBAL = "global";
    // 权重关联类型：一级层级考核项
    public static final String WEIGHT_REL_ONE_ASSESS = "oneAssess";

    //考评体系得分选项
    //省
    public static final String PROV = "prov";
    //市
    public static final String CITY = "city";
    //区
    public static final String DISTRICT = "district";
    //县
    public static final String COUNTY = "county";

    public static final String SPACE_DIM_PROV = "1";

    public static final String SPACE_DIM_CITY = "2";

    public static final String SPACE_DIM_DISTRICT = "3";

    public static final String SPACE_DIM_COUNTY = "4";

    public static final Integer FOUR = 4;
    public static final Integer THREE = 3;
    public static final Integer TWO = 2;
    public static final Integer ONE = 1;
    public static final Integer ZERO = 0;

    public static final String FOUR_STR = "4";
    public static final String THREE_STR = "3";
    public static final String TWO_STR = "2";
    public static final String ONE_STR = "1";
    public static final String ZERO_STR = "0";
    public static final String NEGATIVE_ONE = "-1";
    /**
     * 行政区划
     */
    public static final String IOC_REGION = "IOC_REGION";
    /**
     * 国 行政区划编码
     */
    public static final String COUNTRY_REGION_CODE = "000000000000";

    /**
     *
     */
    public static final String REGION_TREE = "regionTree";

    /**
     * 匹配整数正则字符串
     */
    public static final String INT_REGEX_STR = "^\\d+$";

    /**
     * 政策类型 条例
     */
    public static final String POLICY_TYPE_ORDINANCE = "条例";

    /**
     * 政策类型 行动方案
     */
    public static final String POLICY_TYPE_PLAN = "行动方案";
    /**
     * 一级指标层级父层级ID
     */
    public static final String ONE_INDEX_LEVEL_PARENT_ID = "0";


    /**
     * 指标区县范围
     */
    public static final String ASSESS_REGION_TYPE_ALL = "all";
    /**
     * 逗号
     */
    public static final String COMMA = ",";

    /**
     * 中横线
     */
    public static final String MIDDLE_LINE = "-";

    /**
     * 中横线
     */
    public static final String DONG_HAO =  "、";


    public static final String GOV_NAME = "甘肃省2024";
    public static final String GOV_NAME_VALUE = "数据填报";
    public static final String CONCLUSION = "答题已完成，感谢您从百忙之中抽出时间参与本次问卷!";
    public static final String WELCOME = "为了给您提供更好的服务，希望您能抽出几分钟时间，将您的感受和建议告诉我们，我们非常重视每位用户的宝贵应见，期待您的参与!现在我们就马上开始吧!";




    /**
     * 考评体系版本格式校验正则
     */
    public static final String ASSESS_SYSTEM_VERSION_REGEX = "^[1-9]{1,2}\\.[0-9]{1}$";

    // 参数长度校验 长度：10，20，30，32，64，128，512，500
    /**
     * 参数长度10
     */
    public static final Integer PARAM_LENGTH_10 = 10;
    /**
     * 参数长度10
     */
    public static final Integer PARAM_LENGTH_20 = 20;
    /**
     * 参数长度10
     */
    public static final Integer PARAM_LENGTH_30 = 30;
    /**
     * 参数长度10
     */
    public static final Integer PARAM_LENGTH_32 = 32;
    /**
     * 参数长度10
     */
    public static final Integer PARAM_LENGTH_50 = 50;
    /**
     * 参数长度10
     */
    public static final Integer PARAM_LENGTH_64 = 64;
    /**
     * 参数长度10
     */
    public static final Integer PARAM_LENGTH_128 = 128;
    /**
     * 参数长度10
     */
    public static final Integer PARAM_LENGTH_512 = 512;
    /**
     * 参数长度2000
     */
    public static final Integer PARAM_LENGTH_2000 = 2000;

    // 考评体系
    /**
     * 考评体系 初始版本号
     */
    public static final String START_VERSION = "1.0";
    /**
     * 考评体系满意度 + 指标总得分
     */
    public static final String TOTAL_SCORE = "100";
    /**
     * 考评体系历史版本判断：是历史版本
     */
    public static final String IS_HISTORY = "1";
    /**
     * 考评体系应用范围 全省
     */
    public static final String APPLICATION_SCOPE_1 = "1";
    /**
     * 考评体系应用范围 省内
     */
    public static final String APPLICATION_SCOPE_2 = "2";
    public static final String DELETE = "delete";
    /**
     * 计分模型对应的算法
     */
    public static final String[] CALC_MODEL_ARR = {"+","-","*","/","(",")"};

    public static final String COMMON_QUESTION_COMPANY_NAME = "贵公司名称为";
    public static final String COMMON_QUESTION_NAME = "您的姓名";
    public static final String COMMON_QUESTION_IDENTITY = "请问您在企业/单位";



    //问卷状态
    //待设计
    public static final String IOC_QUESTIONNAIRE_STATE_DESIGN ="0";
    //未提交
    public static final String IOC_QUESTIONNAIRE_STATE_NOTSUBMITTED = "1";
    //已驳回
    public static final String IOC_QUESTIONNAIRE_STATE_REJECT = "2";
    //待审核
    public static final String IOC_QUESTIONNAIRE_STATE_UNAUDITED = "3";
    //待发布
    public static final String IOC_QUESTIONNAIRE_STATE_UNPUBLISH = "4";
    //已发布
    public static final String IOC_QUESTIONNAIRE_STATE_PUBLISH = "5";
    //未开始
    public static final String IOC_QUESTIONNAIRE_STATE_NOTSTATE = "5";
    //已结束
    public static final String IOC_QUESTIONNAIRE_STATE_FINISH = "7";
    //收集中
    public static final String IOC_QUESTIONNAIRE_STATE_START = "8";
    //已暂停
    public static final String IOC_QUESTIONNAIRE_STATE_STOP = "9";


    //操作类型
    //设计
    public static final String IOC_QUESTIONNAIRE_OPERATE_DESIGN = "design";
    //设计完毕
    public static final String IOC_QUESTIONNAIRE_OPERATE_DESIGN_COMPLETED = "designCompleted";
    //驳回
    public static final String IOC_QUESTIONNAIRE_OPERATE_REJECT = "reject";
    //提交审核
    public static final String IOC_QUESTIONNAIRE_OPERATE_SUBMIT = "submit";
    //审核通过
    public static final String IOC_QUESTIONNAIRE_OPERATE_PASS = "pass";
    //发布问卷
    public static final String IOC_QUESTIONNAIRE_OPERATE_PUBLISH = "publish";
    //重新提交审核
    public static final String IOC_QUESTIONNAIRE_OPERATE_RESUBMIT = "resubmit";
    //未开始收集
    public static final String IOC_QUESTIONNAIRE_OPERATE_notStarted = "notStarted";
    //开启收集操作
    public static final String IOC_QUESTIONNAIRE_OPERATE_START = "start";
    //停止收集操作
    public static final String IOC_QUESTIONNAIRE_OPERATE_STOP = "stop";
    //结束
    public static final String IOC_QUESTIONNAIRE_OPERATE_FINISH = "finish";

    //核验任务操作类型 待核验
    public static final String IOC_TASK_OPERATE_TYPE_NOT_TASK_VERIFY = "not_task_verify";
    //核验任务操作类型 驳回
    public static final String IOC_TASK_OPERATE_TYPE_REJECT = "reject";
    //核验任务操作类型 待审核
    public static final String IOC_TASK_OPERATE_TYPE_NOT_TASK_CHECK = "not_task_check";
    //核验任务操作类型 归档
    public static final String IOC_TASK_OPERATE_TYPE_RECORD = "record";

    //核验任务状态 待核验
    public static final String IOC_TASK_STATE_NOT_TASK_VERIFY ="0";
    //核验任务状态 驳回
    public static final String IOC_TASK_STATE_REJECT ="1";
    //核验任务状态 待审核
    public static final String IOC_TASK_STATE_NOT_TASK_CHECK ="2";
    //核验任务状态 归档
    public static final String IOC_TASK_STATE_RECORD  ="3";

    //问卷是否选择分类
    public static final String IOC_QUESTIONNAIRE_SINGLE = "single";
    public static final String IOC_QUESTIONNAIRE_MULTIPLE = "multiple";
    public static final String PUBLIC_AND_GLOBAL_ONE_TWO = "1,2";



    //填报流程状态 ioc_fill_state
    public static final String IOC_FILL_STATE  ="ioc_fill_state";
    //待处理 10
    public static final String IOC_FILL_STATE_PENDING_PROCESSING  ="10";
    //已处理 11
    public static final String IOC_FILL_STATE_PROCESSED  ="11";
    //已超期 22
    public static final String IOC_FILL_STATE_EXPIRED  ="12";
    //待审核 13
    public static final String IOC_FILL_STATE_AUDIT  ="13";
    //已驳回 14
    public static final String IOC_FILL_STATE_REJECTED  ="14";
    // 处理流程状态 提交卷子 | 审核驳回 | 审核通过
    public static final String SUBMIT_PAPER = "submit_paper";
    public static final String CHECK_REJECT = "check_reject";
    public static final String CHECK_PASS = "check_pass";


    /**
     * 区间
     */
    public static final String COMPUTE_TYPE_INTERVAL = "区间";
    /**
     * 实时
     */
    public static final String COMPUTE_TYPE_REALTIME = "实时";
    /**
     * 全局考核项
     */
    public static final String GLOBAL_ASSESS = "全局考核项";
    /**
     * 一级指标考核项
     */
    public static final String ONE_LEVEL_ASSESS = "一级考核项";
    /**
     * 异步任务状态-等待执行
     */
    public static final String IOC_ASYN_STATUS_W = "W";
    /**
     * 异步任务状态-正在执行
     */
    public static final String IOC_ASYN_STATUS_S = "S";
    /**
     * 异步任务状态-结束
     */
    public static final String IOC_ASYN_STATUS_E = "E";


}
