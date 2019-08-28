package com.tw.apistackbase.data;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.apistackbase.model.Employee;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DB {
    private static final String str = "[{\"id\":0,\"name\":\"Xiaoming\",\"age\":20,\"gender\":\"Male\"},{\"id\":1,\"name\":\"Xiaohong\",\"age\":19,\"gender\":\"Female\"},{\"id\":2,\"name\":\"Xiaozhi\",\"age\":15,\"gender\":\"Male\"},{\"id\":3,\"name\":\"Xiaogang\",\"age\":16,\"gender\":\"Male\"},{\"id\":4,\"name\":\"Xiaoxia\",\"age\":15,\"gender\":\"Female\"}]\n";
    private List<Employee> employees;
    public DB() {
    	ObjectMapper mapper= new ObjectMapper();
        try {
			this.employees = mapper.readValue(str,new TypeReference<List<Employee>>() { });
		} catch (Exception e) {
			this.employees = new ArrayList<>();
		}
    }

    public List<Employee> getAllData() {
        return this.employees;
    }

    public boolean add(Employee employee) {
        return this.employees.add(employee);
    }

    public void update(Employee employee,Integer id) throws Exception {
        for(int i = 0;i<this.employees.size();i++) {
            if(this.employees.get(i).getId() == id) {
                this.employees.set(i,employee);
            }
        }
    }


    public boolean delete(Integer id) {
        for(Employee employee : this.employees) {
            if(employee.getId() == id) {
                return this.employees.remove(employee);
            }
        }

        return  false;
    }
}
