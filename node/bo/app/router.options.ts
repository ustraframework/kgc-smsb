import type { RouterConfig } from '@nuxt/schema'

export default <RouterConfig>{
  scrollBehavior: (to, from, savedPosition) => {
    return new Promise(resolve => {
      setTimeout(() => {
        if (!to.hash) {
          resolve({
            left: 0,
            top: 0,
          })
        } else {
          const top = window.pageYOffset + document.querySelector(to.hash).getBoundingClientRect().top || 0
          resolve({
            left: 0,
            top,
          })
        }
      }, 100)
    })
  },
}
