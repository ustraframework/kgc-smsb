import { defineUstraService } from '#ustra/nuxt/composables/service'
import { baseModels, apiModels, interfaceModels, paginationModels } from '#ustra/core/data'

/**
 * 코드 정보
 */
export interface Code extends baseModels.BaseModel {
  /**
   * 그룹 코드
   */
  grpCd?: string

  /**
   * 상세 코드
   */
  dtlCd?: string
}

/**
 * 검색 조건
 */
export interface Criteria {
  /**
   * 그룹 코드
   */
  grpCd?: string
}

/**
 * 샘플 서비스
 */
export const useSampleService = defineUstraService(({ $ustra, appProps, api, nuxtApp }) => {
  /**
   * 코드 목록 조회
   * @param criteria 검색 조건
   * @returns
   */
  async function getList(criteria: Criteria) {
    return (
      await api.call<apiModels.ApiResponse<Code[]>>({
        url: '/api/system/code/list',
        method: 'POST',
        data: criteria,
      })
    )?.data?.body
  }

  return { getList }
})
