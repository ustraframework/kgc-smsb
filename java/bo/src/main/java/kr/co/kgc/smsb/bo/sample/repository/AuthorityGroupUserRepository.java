package kr.co.kgc.smsb.bo.sample.repository;

import com.gsitm.ustra.java.management.models.UstraAuthorityGroupUserModel;
import kr.co.kgc.smsb.bo.sample.model.AuthorityGroupUserModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthorityGroupUserRepository {

	List<UstraAuthorityGroupUserModel> select(Integer authGrpId);

	int insert(UstraAuthorityGroupUserModel authorityGroupUser);

	int delete(Integer authGrpId);

	int deleteUser(String usrId);

	int deleteGroupUser(Integer authGrpId, String usrId);

	List<AuthorityGroupUserModel> selectUser(String usrId);
}
