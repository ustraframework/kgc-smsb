import { useState } from '#app'
import { onMounted, computed } from '#ustra/nuxt'

export const useStringState = () => {
  const state = useState('state: string')
  const stringValue = computed(() => {
    return 'computed:' + state.value
  })
  onMounted(() => {
    state.value = '22222'
  })

  return {
    state,
    stringValue,
  }
}
