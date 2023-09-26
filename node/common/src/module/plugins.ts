import { Nuxt } from '@nuxt/schema'
import { addPluginTemplate } from '@nuxt/kit'

export const plugins = (nuxt: Nuxt) => {
  addPluginTemplate({
    filename: 'kgc.mjs',
    // @ts-ignore
    order: 200,
    getContents: () => {
      return `
      import plugin from '#kgc/smsb-common/plugins/${nuxt.options.dev ? 'kgc' : 'kgc.ts'}'
      export default plugin
      `
    },
  })
}
