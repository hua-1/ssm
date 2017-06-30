package ssm.dao;

import ssm.model.Person;

import java.util.List;

/**
 * Created by hua on 2017/6/25.
 */
public interface PersonMapper {
    /**
     * 获取所有person的信息
     * @return
     */
    List<Person> getAllPerson();
}
