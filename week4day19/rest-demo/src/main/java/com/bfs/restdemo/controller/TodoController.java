package com.bfs.restdemo.controller;


import com.bfs.restdemo.domain.todo.Todo;
import com.bfs.restdemo.domain.todo.TodoResponse;
import com.bfs.restdemo.domain.common.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController // = @ResponseBody + @Controller
@RequestMapping("todos")
public class TodoController {

    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{id}")
    public TodoResponse getTodo(@PathVariable String id) {

        String requestURL = "https://jsonplaceholder.typicode.com/todos/" + id;
        System.out.println(requestURL);

        try {
            ResponseEntity<Todo> responseEntity = restTemplate.exchange(
                    requestURL,
                    HttpMethod.GET,
                    null,
                    Todo.class);

            return TodoResponse.builder()
                    .status(
                            ResponseStatus.builder()
                                    .success(true)
                                    .message("Success! Todo was found")
                                    .build())
                    .todo(responseEntity.getBody())
                    .build();

        } catch (HttpClientErrorException exception){
            return TodoResponse.builder()
                    .status(
                            ResponseStatus.builder()
                                    .success(false)
                                    .message("Oops, todo was not found")
                                    .build())
                    .build();
        }
    }

}
