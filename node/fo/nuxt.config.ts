const isMobile = process.env.TARGET_DEVICE === 'mobile';

export default defineNuxtConfig({
  ssr: false,
  modules: ['@ustra/nuxt', '@kgc/smsb-common', 'nuxt-primevue', '@nuxtjs/tailwindcss'],
  css: isMobile
    ? ['~/assets/styles/mobile/index.scss', 'primevue/resources/themes/lara-dark-teal/theme.css', 'primeicons/primeicons.css']
    : ['~/assets/styles/desktop/index.scss', 'primevue/resources/themes/lara-dark-teal/theme.css', 'primeicons/primeicons.css'],
  // css: ['primevue/resources/themes/lara-dark-teal/theme.css'],
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
    auth: {
      enabled: true,
      loginPath: '/login',
      failProcessType: 'none',
      expiredProcessType: 'none',
      jwt: {
        useCookie: false,
        accessTokenKey: 'X-SM-FO-TOKEN',
        refreshTokenKey: 'X-SM-REF-FO-TOKEN',
      },
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
  primevue: {
    options: {
      unstyled: false,
    },
    cssLayerOrder: 'tailwind-base, primevue, tailwind-utilities',
  },
});
