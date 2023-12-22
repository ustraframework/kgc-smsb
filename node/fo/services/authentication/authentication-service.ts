import { defineUstraService } from '#ustra/nuxt/composables/service';
import { SmsbBaseModel } from '@kgc/smsb-common/src/data/smsb-base-model';
import { apiModels } from '#ustra/core/data';

/**
 * 로그인 결과
 */
export interface LoginResult extends SmsbBaseModel {
  /**
   * 응답 코드
   */
  resCd?: string;

  /**
   * 인증 여부
   */
  authenticated?: boolean;

  /**
   * 사용자 조회 여부
   */
  hasUser?: boolean;

  /**
   * 사용자 아이디
   */
  userKey?: string;

  /**
   * 사용자 명
   */
  userName?: string;

  /**
   * 패스워드 초기화 여부
   */
  resetPassword?: boolean;

  /**
   * 로그인 실패 수
   */
  loginFailCnt?: number;

  /**
   * 패스워드 변경 필요 여부
   */
  requiredChangePassword?: boolean;

  /**
   * 세션 아이디
   */
  sessionId?: string;
}

/**
 * 인증 관련 서비스
 */
export const useAuthenticationService = defineUstraService(({ $ustra, api }) => {
  /**
   * 아이디 패스워드 인증 처리
   * @param userName 사용자 명
   * @param password 패스워드
   * @returns
   */
  async function idPasswordLogin(userName: string, password: string) {
    return (
      await $ustra.api.call<apiModels.ApiResponse<LoginResult>>({
        url: '/api/authentication/login',
        method: 'POST',
        data: {
          userName,
          password,
        },
        secured: true,
      })
    )?.data?.body;
  }
  /**
   * 로그아웃 처리
   */
  async function logout() {
    try {
      await api.call({
        url: '/api/authentication/logout',
        passOnResponseError: true,
      });
    } catch (e) {
      $ustra.logger.warn(e);
    }
  }

  return {
    idPasswordLogin,
    logout,
  };
});
