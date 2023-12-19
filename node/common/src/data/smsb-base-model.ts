/**
 * 시스템 필드가 포함된 모델
 */
export interface SmsbBaseModel extends Record<string, any> {
  /**
   * 등록일자
   */
  regDttm?: string

  /**
   * 등록 사용자 아이디
   */
  regUserId?: string

  /**
   * 등록 사용자 IP
   */
  regUserIp?: string

  /**
   * 수정일자
   */
  modDttm?: string

  /**
   * 수정자 아이디
   */
  modUserId?: string

  /**
   * 수정자 IP
   */
  modUserIp?: string
}
