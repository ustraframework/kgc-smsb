import { Kgc } from '../plugins/kgc'
import { useNuxtApp } from '#app'

/**
 * $kgc 플러그인 반환
 */
export const useKgc = (): Kgc => {
  const app = useNuxtApp()
  return app['$kgc'] as Kgc
}
