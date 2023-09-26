모델과 서비스는 페이징 기반의 요청을 고려한 baseModel을 사용하여 구성한다.
```typescript
import { baseModels, apiModels } from '#ustra/core/data'

/**
 * 인터페이스 이력 검색 조건
 */
export interface IfsHistCriteria extends apiModels.ApiRequest {
  searchValue: {
    /**
     * 인터페이스 이력 아이디
     */
    ifHistId?: number
    /**
     * 프로세스 아이디
     */
    procId?: string
    /**
     * 요청 아이디
     */
    reqId?: string
    /**
     * 인터페이스 아이디
     */
    ifId?: string
    /**
     * 시스템 코드
     */
    sysCd?: string
    /**
     * 채널 코드
     */
    chnlCd?: any
    /**
     * url
     */
    url?: string
    /**
     * 성공 여부
     */
    succYn?: string
    /**
     * 응답 코드 값
     */
    resCdVal?: string
    /**
     * 검색 기간 시작 일자
     */
    searchSrtDttm?: Date
    /**
     * 검색 기간 종료 일자
     */
    searchEndDttm?: Date

    [propName: string]: any
  }

  [propName: string]: any
}


/**
 * 프레임워크 인터페이스 서비스
 */
export const useUstraInterfaceService = defineUstraService(({ api }) => {

  /**
   * 인터페이스 이력 목록 조회
   * @param criteria 조회 조건
   * @returns
   */
  async function getIntefaceHistories(criteria?: IfsHistCriteria) {
    return (
      await api.call<apiModels.ApiResponse<IfsHist[]>>({
        url: '/api/system/ifshist/list',
        method: 'POST',
        data: criteria,
      })
    )?.data
  }


  return { getIntefaceHistories }

})


```
