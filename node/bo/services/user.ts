import { apiModels } from '#ustra/core/data'
import { defineUstraService } from '#ustra/nuxt/composables'
import { UserCriteria, User } from '../models/user'

/**
 * 사용자 서비스
 */
export const useUstraUserService = defineUstraService(({ $ustra, api }) => {
  /**
   * 사용자 조회
   * @param criteria 검색 조건
   */
  async function getUsers(criteria: UserCriteria) {
    return (
      await api.call<apiModels.ApiResponse<User[]>>({
        url: '/api/sample/user/group',
        method: 'POST',
        data: criteria,
      })
    )?.data?.body
  }

  /**
   * 사용자 상세 정보 조회
   * @param usrId 사용자 아이디
   * @param isPrivate 개인정보용 조회 여부
   * @returns
   */
  async function getUser(usrId: string, isPrivate: boolean = false) {
    return (
      await api.call<apiModels.ApiResponse<User>>({
        url: !isPrivate ? '/api/sample/user/detail' : '/api/system/user/detail/private',
        method: 'POST',
        data: {
          usrId,
          includePassword: false,
        },
      })
    )?.data?.body
  }

  /**
   * 사용자 추가
   * @param user 사용자 정보
   */
  async function add(user: User) {
    user = $ustra.utils.model.removeSystemField(user)

    return (
      await api.call<apiModels.ApiResponse<User>>({
        url: '/api/system/user',
        method: 'POST',
        data: { user },
        passOnResponseCode: ['FM11'],
      })
    )?.data
  }

  /**
   * 사용자 수정
   * @param user 사용자 정보
   * @returns
   */
  async function edit(user: User) {
    user = $ustra.utils.model.removeSystemField(user)

    return (
      await api.call<apiModels.ApiResponse<User>>({
        url: '/api/system/user/edit',
        method: 'POST',
        data: { user },
      })
    )?.data
  }

  /**
   * 사용자 제거
   * @param usrId 사용자 아이디
   * @returns
   */
  async function remove(usrId: string) {
    return (
      await api.call<apiModels.ApiResponse<User>>({
        url: '/api/system/user/remove',
        method: 'POST',
        data: { usrId },
      })
    )?.data
  }

  return { getUsers, getUser, add, edit, remove }
})
