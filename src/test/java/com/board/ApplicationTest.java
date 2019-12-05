package com.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Mock
    BillingResponse response;

    //@Test
    public void contextLoads() {
    }

    //@Test
    public void testSqlSession() throws Exception{
        System.out.println(sqlSession.toString());
    }

    @Test
    public void example(){
        MockitoAnnotations.initMocks(this);
        System.out.println(((BillingResponse) response).getNullCount());
        System.out.println(((BillingResponse) response).getClass());
        System.out.println(((BillingResponse) response).getClass().getDeclaredFields());
        System.out.println(((BillingResponse) response).getClass().getDeclaredFields().length);
//        if (((BillingResponse) response).getNullCount() == ((BillingResponse) response).getClass().getDeclaredFields().length) {
//            //throw new BillingDataNotFoundException("NO CONTENT ERROR, CHECK THE REQUEST BODY");
//        } else if (((BillingResponse) response).getNullCount() >= 1) {
//            //throw new PartialContentException("CONTENT IS PARTIAL, RETRY AGAIN");
//        }
    }

//    public static <T> void validateResponseDataIsPartial(T response) throws  Exception {
//        if (((BillingResponse) response).getNullCount() == ((BillingResponse) response).getClass().getDeclaredFields().length) {
//            //throw new BillingDataNotFoundException("NO CONTENT ERROR, CHECK THE REQUEST BODY");
//        } else if (((BillingResponse) response).getNullCount() >= 1) {
//            ((BillingResponse) response).setT(response);
//            //throw new PartialContentException("CONTENT IS PARTIAL, RETRY AGAIN");
//        }
//    }
}

class BillingResponse {
    //@JsonIgnore
    private int nullCount = 0;

    public void setNullCount(int nullCount) {
        this.nullCount += nullCount;
    }

    public int getNullCount() {
        return nullCount;
    }
}