import { Kgc } from './src/plugins/kgc'

declare module '#app' {
  interface NuxtApp {
    $kgc: Kgc
  }

  interface _NuxtApp {
    $kgc: Kgc
  }
}
declare module 'nuxt/dist/app/nuxt' {
  interface NuxtApp {
    $kgc: Kgc
  }

  interface _NuxtApp {
    $kgc: Kgc
  }
}

declare module '@vue/runtime-core' {
  interface ComponentCustomProperties {
    $kgc: Kgc
  }
}

// global
declare global {
  var $kgc: Kgc

  const toast: typeof window.toast

  namespace NodeJS {
    interface Global {
      $kgc: Kgc
    }
  }
}
