const isMobile = process.env.TARGET_DEVICE === 'mobile'

export default defineNuxtConfig({
  ssr: false,
  modules: ['@ustra/nuxt', '@kgc/smsb-common'],
  css: isMobile ? ['~/assets/styles/mobile/index.scss'] : ['~/assets/styles/desktop/index.scss'],
  dir: {
    pages: isMobile ? 'pages_mobile' : 'pages',
    layouts: isMobile ? 'layouts_mobile' : 'layouts',
  },
  imports: {
    dirs: ['composables/**'],
  },
  typescript: {
    tsConfig: {
      compilerOptions: {
        strict: false,
        skipLibCheck: true,
      },
    },
  },
  experimental: {
    inlineSSRStyles: false,
  },
  routeRules: {
    '/api/**': { proxy: 'http://localhost:11052/api/**' },
  },
  ustra: {
    app: {
      configDirPath: './config',
    },
    nuxt: {
      vuetify: {
        enabled: true,
        mdi: {
          enabled: true,
        },
      },
      env: {
        secret: 'eGZ1MDE2eHc2OGc1dWh3OQ==',
      },
    },
  },
})
