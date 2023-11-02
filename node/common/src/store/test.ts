import { defineInitStore } from '#ustra/nuxt/store'
import { ref } from '#ustra/nuxt'
import { useSessionStorage } from '@vueuse/core'

export const useTempStore = defineInitStore(
  'common:test',
  () => {
    // const string1 = ref<string>(null)
    const string1 = useSessionStorage('string1', null)
    async function loadData() {
      string1.value = '1111'
    }

    return { string1, loadData }
  },
  async store => {
    await store.loadData()
  },
)
