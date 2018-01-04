package net.blover.website.framework;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;


@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class,
                RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
        @Signature(type = Executor.class, method = "get", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class SQLInterceptor implements Interceptor {

    Logger log = LoggerFactory.getLogger(SQLInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
//        Page page =PageUtil.getPage();
//        if(page!=null){
//            RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
//            StatementHandler delegate = (StatementHandler) SQLInterceptor.getFieldValue(handler, "delegate");
//            MappedStatement mappedStatement = (MappedStatement)SQLInterceptor.getFieldValue(delegate, "mappedStatement");
//            BoundSql boundSql = delegate.getBoundSql();
//            Connection connection = (Connection)invocation.getArgs()[0];
//            String sql = boundSql.getSql();
//            if(page.isNeedInvokeCountSql()){
//                page.setTotalCount(this.setTotalRecord(boundSql,
//                        mappedStatement, connection));
//            }
//            String pageSql = PageInterceptor.getPageSql(page, sql);
//            PageInterceptor.setFieldValue(boundSql, "sql", pageSql);
//            PageUtil.removePage();
//        }

        log.info("拦截器");
        return invocation.proceed();
    }

    /**
     * 拦截器对应的封装原始对象的方法
     */
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    /**
     * 设置注册拦截器时设定的属性
     */
    public void setProperties(Properties properties) {
        log.info("打个端点");
    }
}
