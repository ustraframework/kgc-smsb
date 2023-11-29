각 업무별 서비스와 모델은 프로젝트 내의 services/[업무별약자] 경로에 ts 파일로 생성한다. 모델은 별도 파일로 구분하여 생성할 수도 있으나
가급적 서비스 내에 동일한 파일에 관계있는 모델을 정의토록 한다.


- ex) ~/services/cu/cu-sample-service.ts

```typescript
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
```

위와 같이 생성된 서비스는 프로젝트의 ~/service/ 경로로 접근하여 업무별 서비스를 생성하여 사용할 수 있다.
```typescript
import { useSampleService } from '~/services/cu/cu-sample-service'
```
