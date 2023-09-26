import { defineNuxtModule } from '@nuxt/kit'
import { logger } from '#ustra/core'
import { resolve } from 'pathe'
import { plugins } from './plugins'

export default defineNuxtModule({
  meta: {
    name: '@kgc/smsb-common',
    configKey: 'kgc',
    compatibility: {
      nuxt: '^3.0.0',
    },
  },
  async setup(resolvedOptions, nuxt) {
    logger.info('register kgc module...')

    nuxt.options.alias['#kgc/smsb-common'] = 'node_modules/@kgc/smsb-common/src'

    nuxt.hook('vite:extendConfig', config => {
      config.resolve.alias['#kgc/smsb-common'] = resolve(nuxt.options.srcDir, './node_modules/@kgc/smsb-common/src')
    })

    // if (!nuxt.options.dev) {
    //   nuxt.options.ignore = nuxt.options.ignore || []
    //   nuxt.options.ignore.push('pages/pubs/**/*.vue')
    // }

    nuxt.hook('imports:dirs', dirs => {
      dirs.push(resolve(__dirname, '../composables'))
    })

    // add types
    nuxt.hook('prepare:types', ({ references }) => {
      references.push({ types: '@kgc/smsb-common/types' })
    })
    nuxt.options.typescript.tsConfig.compilerOptions.types.push('@kgc/smsb-common/types')

    plugins(nuxt)
  },
})
