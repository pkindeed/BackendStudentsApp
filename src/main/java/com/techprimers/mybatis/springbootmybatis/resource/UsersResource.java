package com.techprimers.mybatis.springbootmybatis.resource;

import com.techprimers.mybatis.springbootmybatis.mapper.UsersMapper;
import com.techprimers.mybatis.springbootmybatis.model.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {

    private UsersMapper usersMapper;

    public UsersResource(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @CrossOrigin("*")
    @GetMapping("/all")
    public List<Users> getAll() {
        return usersMapper.findAll();
    }

    @CrossOrigin("*")
    @PostMapping("/insert")
    private List<Users> insert(@RequestBody Map<String, String> body) {
        Users users = new Users();
        users.setName(body.get("vardas"));
        Long alga =Integer.valueOf(body.get("alga")).longValue();
        users.setSalary(alga);
        usersMapper.insert(users);
        return usersMapper.findAll();
    }

    @CrossOrigin("*")
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete() {
        usersMapper.delete();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
