//package com.hiquanta.cms.restrepositories.v1;
//
//import com.hiquanta.cms.models.RestUser;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
///**
// * Created by hiquanta on 2016/10/27.
// */
//@Repository
//public interface LoginRepository extends JpaRepository<RestUser,Long> {
//  //  @Query(value = "select user0_.id as id1_4_, user0_.createdAt as createdA2_4_, user0_.updatedAt as updatedA3_4_, user0_.email as email4_4_, user0_.password as password5_4_, user0_.role as role6_4_ from users user0_ where user0_.email=:e and user0_.password=:p",nativeQuery = true)
//   RestUser findByEmailAndPassword(
//    //       @Param("e")
//                   String email,
//      //     @Param("p")
//           String password);
//    RestUser findByEmail(String email);
//    RestUser findByEmailAndRole(String email,String role);
//}
