import { useUstra } from '#ustra/nuxt/composables/ustra'

/**
 * alert 창 오픈
 * @param message 내용 메시지
 * @param title 제목 메시지
 * @param caption window top caption
 *
 */
export const useAlert = (message: string, title?: string, caption: string = '안내') => {
  const $ustra = useUstra()
  return $ustra.ui.dialog.dialog({
    type: 'alert',
    title,
    message,
    iconType: 'done',
    caption,
  })
}

/**
 * 오류 alert 창 오픈
 * @param message
 * @param title
 * @param caption
 * @returns
 */
export const useErrorAlert = (message: string, title: string = '오류가 발생하였습니다.', caption: string = '오류 발생 안내') => {
  const $ustra = useUstra()
  return $ustra.ui.dialog.dialog({
    type: 'alert',
    title,
    message,
    iconType: 'error',
    caption,
  })
}

/**
 * confirm 창 오픈
 * @param message 내용 메시지
 * @param title 제목 메시지
 * @param caption window top caption
 *
 */
export const useConfirm = (message: string, title: string = '', caption: string = '확인안내', confirmButtonName = '확인') => {
  const $ustra = useUstra()
  return $ustra.ui.dialog.dialog({
    type: 'confirm',
    title,
    message,
    iconType: 'done',
    caption,
    confirmButtonName,
  }) as Promise<boolean>
}
