import { useAuthenticationService } from '~/services/authentication/authentication-service';

/**
 * 로그아웃 처리
 */
export const useLogout = async (confirmLogout = false) => {
  if (confirmLogout) {
    if (!(await confirm('로그아웃 하시겠습니까?'))) {
      return;
    }
  }

  const service = useAuthenticationService();
  await service.logout();
  $ustra.auth.unauthenicate(false, true);
  useRouter().replace('/login');
};

export interface FoAuthentcationUser {
  /**
   * 사용자 아이디
   */
  id?: string;

  /**
   * 사용자 명
   */
  name?: string;
}

/**
 * 인증 사용자 정보 조회
 */
export const useAuthenticatedUser = () => {
  const $ustra = useUstra();

  return computed(() => {
    const user = $ustra.auth.user || {};
    return {
      id: user.sub,
      name: user.userNm,
    } as FoAuthentcationUser;
  });
};
