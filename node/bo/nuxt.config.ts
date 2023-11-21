export default defineNuxtConfig({
  ssr: false,
  modules: ['@ustra/nuxt', '@kgc/smsb-common'],
  css: ['~/assets/styles/framework/index.scss', '~/assets/styles/management/index.scss'],
  experimental: {
    emitRouteChunkError: 'reload',
  },
  routeRules: {
    '/api/**': { proxy: 'http://localhost:11051/api/**' },
  },
  ustra: {
    i18n: {
      enabled: true,
    },
    auth: {
      enabled: true,
      type: 'jwt',
      jwt: {
        accessTokenKey: 'X-SMSB-BO-AUTH',
        refreshTokenKey: 'X-SMSB-BO-RAUTH',
      },
    },
    nuxt: {
      meta: {
        auth: {
          required: true,
        },
      },
      env: {
        secret: 'NXAxZXQ2ZmtnOGNsMWgxOQ==',
      },
      ckeditor5: {
        enabled: true,
      },
      wijmo: {
        enabled: true,
        styles: {
          theme: 'light',
          addFrameworkCustomStyle: false,
        },
        culture: 'ko',
        samples: {
          additionalMenus: [
            {
              title: 'KGC 영업마케팅',
              icon: 'mdi-group',
              items: [
                { title: '서비스 생성 예제', componentPath: '~/components/samples/service/index.vue' },
                { title: 'Dialog', icon: 'mdi-alert-octagram-outline', componentPath: '~/components/samples/dialog/index.vue' },
                { title: '[Grid]수정가능한 열 설정', componentPath: '~/components/samples/grid-header/index.vue' },
                { title: 'File', componentPath: '~/components/samples/file/index.vue' },
              ],
            },
          ],
          copyResource: {
            enabled: true,
            overwrite: false,
          },
        },
      },
      management: {
        enabled: true,
        ui: {
          tabMenu: {
            enabled: true,
            maximumTabNumbers: 10,
          },
          defaultPage: {
            system: {
              copyResource: {
                enabled: true,
                overwrite: false,
              },
            },
            login: {
              include: false,
            },
            main: {
              include: false,
            },
            layout: {
              include: false,
            },
          },
        },
      },
    },
  },
})
