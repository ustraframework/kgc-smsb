package kr.co.kgc.smsb.bo.sample.repository;

import com.gsitm.ustra.java.management.models.UstraUserModel;
import kr.co.kgc.smsb.bo.sample.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserRepository {

	List<UserModel> selects(UserModel.Criteria criteria);

	UserModel select(String usrId);

	int insert(UstraUserModel user);

	int update(UstraUserModel user);

	int updatePrivate(UstraUserModel user);

	int updatePassword(UstraUserModel user);

	int updateSuccessLogin(UstraUserModel user);

	int updateFailLogin(UstraUserModel user);

	int updateFailLoginWithoutCnt(UstraUserModel user);

	int delete(String usrId);

	int updateUnlock(String usrId, String nowDt, String useEndDt, String updUsrId, String updUsrIp);

	int updateResetPassword(String usrId, String pwd, String nowDt, String useEndDt, String updUsrId, String updUsrIp);

	int updateResetExpire(String usrId, String nowDt, String useEndDt, String updUsrId, String updUsrIp);

	int updateUsrApv(String usrId, Integer usrApvId, String updUsrId, String updUsrIp);

	List<UserModel> selectAuthGrpUsers(UserModel.Criteria criteria);

	UstraUserModel selectUserApvId(Integer usrApvId);

	int updateUsrStt(String usrId, String usrSttCd, String nowDt, String useEndDt, String updUsrId, String updUsrIp);

	int updateUsrApvCmpl(String usrId, String apvCmplYn, String nowDt, String useEndDt, String updUsrId,
			String updUsrIp);

	List<UstraUserModel> selectUnLoginUserList(Integer days);
}
