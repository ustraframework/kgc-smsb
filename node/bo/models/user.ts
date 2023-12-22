/**
 * 사용자
 * @exports {@link UserCriteria} {@link User} {@link UserMenus} {@link UserMenuCriteria} {@link UserMenu}
 * @packageDocumentation
 */

/**
 * 사용자 모델
 */
import { baseModels } from '#ustra/core/data'
import { UsrSttCd } from './common-code'

export interface UserCriteria {
  /**
   * 사용자 아이디 & 사용자명
   */
  usrId?: string

  /**
   * 사용자 명
   */
  usrNm?: string

  /**
   * 사용자 상태 코드
   */
  usrSttCd?: UsrSttCd

  /**
   * 사용 구분 코드
   */
  useDvCd?: string

  /**
   * 사용 구분 코드 목록
   */
  useDvCds?: string[]

  /**
   * 부서 명
   */
  deptNm?: string

  /**
   * 소속 그룹 여부
   */
  authGrpNoneYn?: string

  /**
   * 소속 그룹 리스트 여부
   */
  showAuthNoneGrp?: boolean

  [propName: string]: any
}

type UserBase = baseModels.BaseModel & UserCriteria

/**
 * 사용자
 */
export interface User extends UserBase {
  /**
   * 사용자 아이디
   */
  usrId?: string

  /**
   * 사용자명
   */
  usrNm?: string

  /**
   * 부서 코드
   */
  deptCd?: string

  /**
   * 회사명
   */
  deptNm?: string

  /**
   * 비밀번호
   */
  pwd?: string

  /**
   * 비밀번호 최종 수정 일시
   */
  pwdLstUpdDttm?: string | Date

  /**
   * 이메일
   */
  email?: string

  /**
   * 전화번호
   */
  phNo?: string

  /**
   * 핸드폰 번호
   */
  cphNo?: string

  /**
   * 팩스번호
   */
  faxNo?: string

  /**
   * 권한 그룹 목록
   */
  authGrps?: string[]

  /**
   * 사용시작일
   */
  useSrtDt?: string

  /**
   * 사용종료일
   */
  useEndDt?: string

  /**
   * 사용구분코드
   */
  useDvCd?: string

  /**
   * 최종 로그인 일시
   */
  lstLoginDttm?: string

  /**
   * 로그인 실패 건수
   */
  loginFailCnt?: number

  /**
   * 비밀번호 초기화 여부
   */
  pwdResetYn?: string

  /**
   * 아이피 제한 여부
   */
  ipLmtYn?: string

  /**
   * 아이피 목록
   */
  ipList?: any

  /**
   * 사번
   */
  empNo?: string

  /**
   * 비교
   */
  rmk?: string

  /**
   * 기관 코드
   */
  orgCd?: string

  /**
   * 승인 완료 여부
   */
  apvCmplYn?: string

  /**
   * 사용자 승인 아이디
   */
  usrApvId?: string

  /**
   * 소속 그룹
   */
  authGrp?: string

  [propName: string]: any
}

/**
 * 사용자 메뉴 목록
 */
export interface UserMenus {
  updates: Array<UserMenu>
}

/**
 * 사용자 메뉴 검색 조건
 */
export interface UserMenuCriteria extends Record<string, any> {
  /**
   * 사용자아이디
   */
  usrId?: string

  /**
   * 시스템 코드
   */
  sysCd?: string
}

type UserMenuBase = baseModels.BaseModel & UserMenuCriteria

/**
 * 사용자 메뉴
 */
export interface UserMenu extends UserMenuBase {
  /**
   * 사용자아이디
   */
  usrId?: string
  /**
   * 메뉴아이디
   */
  mnuId?: string
  /**
   * 메뉴명
   */
  mnuNm?: string
  /**
   * 메뉴URL
   */
  mnuUrl?: string
  /**
   * 기본메뉴여부
   */
  defMnuYn?: string
  /**
   * 정렬번호
   */
  srtNo?: string

  /**
   * 시스템 코드
   */
  sysCd?: string
}

export interface Criteria {
  /**
   * 사용자 아이디
   */
  usrId?: string

  /**
   * 사용자 명
   */
  usrNm?: string

  /**
   * 검색 기간 시작 일자
   */
  searchSrtDttm?: Date
  /**
   * 검색 기간 종료 일자
   */
  searchEndDttm?: Date

  /**
   * 비밀번호 포함 여부
   */
  includePassword?: boolean

  [propName: string]: any
}

type UserHistBase = baseModels.BaseModel & Criteria

/**
 * 사용자 이력
 */
export interface UserHist extends UserHistBase {
  /**
   * 사용자 아이디
   */
  usrId?: string

  /**
   * 입력 일시
   */
  inpDttm?: Date

  /**
   * 사용자명
   */
  usrNm?: string

  /**
   * 부서 코드
   */
  deptCd?: string

  /**
   * 회사명
   */
  deptNm?: string

  /**
   * 비밀번호
   */
  pwd?: string

  /**
   * 비밀번호 최종 수정 일시
   */
  pwdLstUpdDttm?: string

  /**
   * 이메일
   */
  email?: string

  /**
   * 전화번호
   */
  phNo?: string

  /**
   * 핸드폰 번호
   */
  cphNo?: string

  /**
   * 팩스번호
   */
  faxNo?: string

  /**
   * 사용자 상태 코드
   */
  usrSttCd?: string
  /**
   * 사용자 상태 명
   */
  usrSttNm?: string

  /**
   * 사용시작일
   */
  useSrtDt?: string

  /**
   * 사용종료일
   */
  useEndDt?: string

  /**
   * 사용구분코드
   */
  useDvCd?: string
  /**
   * 사용구분명
   */
  useDvNm?: string

  /**
   * 최종 로그인 일시
   */
  lstLoginDttm?: string

  /**
   * 로그인 실패 건수
   */
  loginFailCnt?: number

  /**
   * 비밀번호 초기화 여부
   */
  pwdResetYn?: string

  /**
   * 아이피 제한 여부
   */
  ipLmtYn?: string

  /**
   * 아이피 목록
   */
  ipList?: string

  /**
   * 사원 번호
   */
  empNo?: string

  /**
   * 비교
   */
  rmk?: string

  /**
   * 기관 코드
   */
  orgCd?: string
  /**
   * 기관 명
   */
  orgNm?: string

  /**
   * 업무 구분 코드
   */
  workDvCd?: string
  /**
   * 업무 구분 명
   */
  workDvNm?: string

  /**
   * 사용 시간 초
   */
  useSec?: number
}
