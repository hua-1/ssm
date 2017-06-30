package ssm.service;

import ssm.model.Person;

import java.util.List;

/**
 * Created by hua on 2017/6/25.
 */
public interface PersonService {
    /**
     * 获得person的全部信息
     * @return
     */
    List<Person> getAllPerson();
}
