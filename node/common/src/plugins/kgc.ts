import { defineNuxtPlugin, NuxtApp } from '#app'
import { useUstra } from '#ustra/nuxt/composables/ustra'
import { useTempStore } from '../store/test'
import { core } from '#ustra/core/utils'

export class Kgc {
  public tempStore: Awaited<ReturnType<typeof useTempStore>> = null

  constructor(private nuxtApp: NuxtApp) {}

  async init() {
    this.tempStore = await useTempStore()
  }
}

export default defineNuxtPlugin(async nuxtApp => {
  const kgc = new Kgc(nuxtApp as NuxtApp)
  await kgc.init()

  core['$kgc'] = kgc

  const $ustra = useUstra()
  $ustra.logger.info('register kgc plugin')

  return {
    provide: {
      kgc,
    },
  }
})
