import { defineUstraService } from '#ustra/nuxt/composables/service'
import { baseModels, apiModels, interfaceModels, paginationModels } from '#ustra/core/data'

/**
 * 마스터_회원_약관 정보
 */
export interface ChlTm extends baseModels.BaseModel {
  /**
   * 채널_코드
   */
  chnlCd?: string
  /**
   * 약관_코드
   */
  termCd?: string
  /**
   * 약관_버전_번호
   */
  termVrsnNo?: string
  /**
   * 약관_유형_구분코드
   */
  termPatrDvcd?: string
  /**
   * 약관_명
   */
  termNm?: string
  /**
   * 적용_시작_일자
   */
  aplStDt?: string
  /**
   * 적용_종료_일자
   */
  aplEdDt?: string

  /**
   * 약관_내용
   */
  termCntt?: string
  /**
   * 필수_동의_약관_여부
   */
  esntAgrmTermYn?: string

  /**
   * 요청 구분 (C/U)
   */
  inReqGbn?: string

  /**
   * SP 기본 입력, 화면 ID
   */
  ioUiId?: string
}

/**
 * 검색 조건
 */
export interface Criteria {
  /**
   * 채널 코드
   */
  schChnlCd?: string

  /**
   * 약관 유형 코드
   */
  schTermPatrDvcd?: string

  /**
   * 약관 명
   */
  schTermNm?: string

  /**
   * 기준 일자
   */
  schAplDt?: string

  /**
   * SP 기본 입력, 화면 ID
   */
  ioUiId?: string
}

/**
 * SP 응답
 */
export interface ChlTmSp {
  /**
   * SP 응답 코드
   */
  otResponCode?: string

  /**
   * SP 응답 메시지
   */
  otResMsg?: string

  /**
   * 레코드
   */
  record?: ChlTm[]
}

/**
 * 채널별 약관정보 관리 서비스
 */
export const useChlTmMgntService = defineUstraService(({ $ustra, appProps, api, nuxtApp }) => {
  /**
   * 약관 목록 조회
   * @param criteria 검색 조건
   * @returns
   */
  async function getList(criteria: Criteria) {
    return (
      await api.call<apiModels.ApiResponse<ChlTmSp>>({
        url: '/api/biz/bi/tm/chl-tm-mgnt/gets',
        method: 'POST',
        data: criteria,
      })
    )?.data?.body
  }

  /**
   * 저장
   * @param criteria 데이터
   * @returns
   */
  async function save(criteria: ChlTm) {
    return (
      await api.call<apiModels.ApiResponse<ChlTmSp>>({
        url: '/api/biz/bi/tm/chl-tm-mgnt/save',
        method: 'POST',
        data: criteria,
      })
    )?.data?.body
  }

  return { getList, save }
})
