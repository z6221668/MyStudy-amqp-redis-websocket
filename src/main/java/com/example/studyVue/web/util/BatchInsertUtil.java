package com.example.studyVue.web.util;

/**
 * 批量插入类
 */
@Component
public class BatchInsertUtil {

    /**
     * 拼接的最大条数
     */
    private static final int batchCountToSQL = 100;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 批量插入方法， consumer为mapper对应方法，list为插入所需数据,这里是每2000条提交一次，可自定义为其他参数
     */
    public <T,M> void batchInsert(List<T> list,Class<M> mapper, BiConsumer<T,M> consumer){
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        M modelMapper = sqlSession.getMapper(mapper);
            for (int i = 0; i < list.size(); i++) {
                consumer.accept(list.get(i), modelMapper);
                if (i%2000==1999){
                    sqlSession.commit();
                    sqlSession.clearCache();
                }
            }
            sqlSession.commit();
            sqlSession.close();
    }
}
