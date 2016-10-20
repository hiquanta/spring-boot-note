//package com.example;
//
//import com.example.service.ExampleProperties;
////import com.example.web.HelloController;
//import com.example.web.UserController;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.hamcrest.Matchers;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockServletContext;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.hamcrest.core.IsEqual.equalTo;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = MockServletContext.class)
//@WebAppConfiguration
////@SpringApplicationConfiguration(MavenDemoApplication.class)
//public class MavenDemoApplicationTests {
//    private MockMvc mvc;
//    private static final Log log = LogFactory.getLog(MavenDemoApplicationTests.class);
////    @Autowired
////    private ExampleProperties exampleProperties;
//
//    @Before
//    public void setUp() throws Exception {
//        mvc = MockMvcBuilders.standaloneSetup(//new HelloController(),
//                new UserController()).build();
//
//    }
//
//    @Test
//    public void getHello() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("Hello World")));
//    }
//
//
//    @Test
//    public void testUserController() throws Exception {
//        //  	测试UserController
//        RequestBuilder request = null;
//// 1、get查一下user列表，应该为空
//        request = MockMvcRequestBuilders.get("/users/");
//        mvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("[]")));
//// 2、post提交一个user
//        request = MockMvcRequestBuilders.post("/users/")
//                .param("id", "1")
//                .param("name", "测试大师")
//                .param("age", "20");
//        mvc.perform(request)
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(content().string(equalTo("success")));
//        // 3、get获取user列表，应该有刚才插入的数据
//        request = get("/users/");
//        mvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(content().string(Matchers.equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));
//
//        // 4、put修改id为1的user
//        request = put("/users/1")
//                .param("name", "测试终极大师")
//                .param("age", "30");
//        mvc.perform(request)
//                .andExpect(content().string(Matchers.equalTo("success")));
//
//        // 5、get一个id为1的user
//        request = get("/users/1");
//        mvc.perform(request)
//                .andExpect(content().string(Matchers.equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));
//
//        // 6、del删除id为1的user
//        request = delete("/users/1");
//        mvc.perform(request)
//                .andExpect(content().string(Matchers.equalTo("success")));
//
//        // 7、get查一下user列表，应该为空
//        request = get("/users/");
//        mvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(content().string(Matchers.equalTo("[]")));
//    }
//
////    @Test
////    public void getProperties() throws Exception {
////        Assert.assertEquals(exampleProperties.getName(), "hiquanta");
////        Assert.assertEquals(exampleProperties.getTitle(), "Spring Boot");
////        Assert.assertEquals(exampleProperties.getDesc(),"hiquanta leaning Spring Boot");
////        log.info("随机数测试输出：");
////        log.info("随机字符串 : " + exampleProperties.getValue());
////        log.info("随机int : " + exampleProperties.getNumber());
////        log.info("随机long : " + exampleProperties.getBignumber());
////        log.info("随机10以下 : " + exampleProperties.getTest1());
////        log.info("随机10-20 : " + exampleProperties.getTest2());
////    }
//
//}
