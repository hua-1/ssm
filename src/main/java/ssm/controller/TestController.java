package ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.model.Person;
import ssm.service.PersonService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hua on 2017/6/25.
 */
@Controller
public class TestController {

    @Resource
    private PersonService personService;

    @RequestMapping("/person")
    public void getPersonInfo(){
        List<Person> persons = personService.getAllPerson();
        if (persons!=null) {
            for (Person person : persons) {
                System.out.println("person:"+person);
            }
        }
    }

}
