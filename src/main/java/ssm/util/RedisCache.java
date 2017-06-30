package ssm.util;


import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by hua on 2017/6/25.
 * 使用第三方数据库redis作为缓存
 */
public class RedisCache implements Cache {

    private static JedisConnectionFactory jedisConnectionFactory;

    private  final  String id;


    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public RedisCache(final String id){
        if (id == null) {
            throw new IllegalArgumentException("cache instances require an ID");
        }
        this.id = id;
    }






    public String getId() {
        return this.id;
    }

    public void putObject(Object key, Object value) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>key:"+key);

        JedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
            System.out.println("**"+serializer.serialize(key));
            connection.set(serializer.serialize(key), serializer.serialize(value));
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (connection != null) {
                connection.close();
            }
        }
    }

    public Object getObject(Object key)
    {
        System.out.println("--------------------------------key:"+key);
        Object result = null;
        JedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
            result = serializer.deserialize(connection.get(serializer.serialize(key)));
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (connection != null) {
                connection.close();
            }
        }

        return result;
    }

    public Object removeObject(Object key) {
        JedisConnection connection = null;
        Object result = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            RedisSerializer<Object> serializer = new JdkSerializationRedisSerializer();
            result = connection.expireAt(serializer.serialize(key), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (connection != null) {
                connection.close();
            }
        }
        return result;

    }

    public void clear() {
        JedisConnection connection=null;
        try {
         connection=   jedisConnectionFactory.getConnection();
         connection.flushDb();
         connection.flushAll();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (connection !=null){
                connection.close();
            }
        }
    }

    public int getSize() {
        int result = 0;
        JedisConnection connection = null;
        try {
            connection = jedisConnectionFactory.getConnection();
            result = Integer.valueOf(connection.dbSize().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }

    public ReadWriteLock getReadWriteLock()
    {
        return this.readWriteLock;
    }

    public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        RedisCache.jedisConnectionFactory = jedisConnectionFactory;
    }
}
