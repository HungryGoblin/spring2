package ru.geekbrains.product.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisTest {
   public static void main(String[] args) {
      // test connection
      Jedis jedis = new Jedis("localhost");
      System.out.println("Server is running: " + jedis.ping());
      // test write/read value
      jedis.set("current_lesson", "spring2.lesson3");
      System.out.println("Stored string in redis:" + jedis.get("current_lesson"));
      // test write/read list
      jedis.lpush("db_list", "Redis");
      jedis.lpush("db_list", "Mongodb");
      jedis.lpush("db_list", "Mysql");
      List<String> list = jedis.lrange("db_list", 0, 2);
      System.out.println(list);
   } 
} 