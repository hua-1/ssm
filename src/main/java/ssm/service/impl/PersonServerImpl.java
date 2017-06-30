package ssm.service.impl;

import org.springframework.stereotype.Service;
import ssm.dao.PersonMapper;
import ssm.model.Person;
import ssm.service.PersonService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hua on 2017/6/25.
 */
@Service
public class PersonServerImpl implements PersonService {

    @Resource
    private PersonMapper personMapper;

    public List<Person> getAllPerson() {
        System.out.println("===== 获取person信息 =====");
        return personMapper.getAllPerson();
    }
}
