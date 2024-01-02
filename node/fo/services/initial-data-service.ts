import { defineUstraService } from '#ustra/nuxt/composables/service';
import { apiModels } from '#ustra/core/data';

/**
 * 프로퍼티 정보
 */
export interface Sns {
  /**
   * sns id
   */
  snsId: string;

  /**
   * sns pw
   */
  snsPw: string;
}

/**
 * 서비스
 */
export const useInitialDataService = defineUstraService(({ $ustra, appProps, api, nuxtApp }) => {
  /**
   * 초기 데이터 조회
   * @returns
   */
  async function getInitData() {
    return (
      await api.call<apiModels.ApiResponse<{ sns: Sns }>>({
        url: '/api/sample/init-data',
        excludeAuthValidation: true,
      })
    )?.data?.body;
  }

  return { getInitData };
});
