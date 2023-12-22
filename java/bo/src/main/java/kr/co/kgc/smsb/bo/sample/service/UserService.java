package kr.co.kgc.smsb.bo.sample.service;

import com.gsitm.ustra.java.core.utils.UstraMaskingUtils;
import com.gsitm.ustra.java.data.mybatis.proxy.MapperManager;
import com.gsitm.ustra.java.management.models.UstraAuthorityGroupUserModel;
import com.gsitm.ustra.java.management.models.UstraUserModel;
import com.gsitm.ustra.java.management.repositories.UstraAuthorityGroupUserRepository;
import com.gsitm.ustra.java.management.repositories.UstraUserRepository;
import com.gsitm.ustra.java.management.services.UstraUserService;
import kr.co.kgc.smsb.bo.sample.model.AuthorityGroupUserModel;
import kr.co.kgc.smsb.bo.sample.model.UserModel;
import kr.co.kgc.smsb.bo.sample.repository.AuthorityGroupUserRepository;
import kr.co.kgc.smsb.bo.sample.repository.SamplePaginationRepository;
import kr.co.kgc.smsb.bo.sample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AuthorityGroupUserRepository authorityGroupUserRepository;

	public List<UserModel> getUsers(UserModel.Criteria criteria) {
		if (criteria.getShowAuthNoneGrp() != null && criteria.getShowAuthNoneGrp()) {
			return userRepository.selectAuthGrpUsers(criteria);
		}

		List<UserModel> users = userRepository.selects(criteria)
				.stream()
				.peek(user->user.setPwd(null))
				.collect(Collectors.toList());

		if (criteria.isMaskPrivateInfo()) {
			UstraMaskingUtils.maskTextFields(users);
		}

		return users;
	}

	public UserModel getUser(String usrId) {
		final UserModel user = userRepository.select(usrId);
		if (user == null) {
			return null;
		}

		final List<AuthorityGroupUserModel> groupList = authorityGroupUserRepository.selectUser(usrId);
		List<Integer> collect = groupList.stream()
				.map(each -> each.getAuthGrpId())
				.collect(Collectors.toList());
		user.setAuthGrps(collect);

		String authGrpNames = groupList.stream().map(group->group.getAuthGrpNm())
				.collect(Collectors.joining(", "));
		user.setAuthGrp(authGrpNames);

		return user;
	}
}
