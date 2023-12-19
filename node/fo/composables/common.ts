/**
 * mobile web application 여부 확인
 * @returns
 */
export const isMobileWeb = () => {
  const runtimeConfig = useRuntimeConfig();
  return runtimeConfig.public.TARGET_DEVICE === 'mobile';
};
