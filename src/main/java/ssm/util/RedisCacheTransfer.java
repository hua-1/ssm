package ssm.util;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * Created by hua on 2017/6/25.
 */
public class RedisCacheTransfer {
    public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        RedisCache.setJedisConnectionFactory(jedisConnectionFactory);
    }
}
