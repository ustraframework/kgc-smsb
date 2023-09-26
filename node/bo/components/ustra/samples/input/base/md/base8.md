```html
<UBox>
  <UItem>
    <UButtonGroup v-model="data2" id="radiobox8" type="radio" />
    <UButtonGroup v-model="data2" id="radiobox81" type="radio" :checkValue="data2Check" />
  </UItem>
</UBox>
<script setup lang="ts">
import { reactive, ref } from '#ustra/nuxt'

const data2 = reactive([
  { value: 1, label: 'test1' },
  { value: 2, label: 'test2' },
  { value: 3, label: 'test3' },
  { value: 4, label: 'test4' },
])
const data2Check = ref<string>('1')
</script>
```
