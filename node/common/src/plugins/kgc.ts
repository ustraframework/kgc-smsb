import { defineNuxtPlugin, NuxtApp } from '#app'
import { useUstra } from '#ustra/nuxt/composables/ustra'

export class Kgc {
  constructor(private nuxtApp: NuxtApp) {}
}

export default defineNuxtPlugin(nuxtApp => {
  const kgc = new Kgc(nuxtApp)

  const $ustra = useUstra()
  $ustra.logger.info('register kgc plugin')

  return {
    provide: {
      kgc,
    },
  }
})
