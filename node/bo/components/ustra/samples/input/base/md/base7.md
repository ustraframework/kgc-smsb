```html
<UBox>
  <UItem>
    <UButtonGroup v-model="data1" id="checkbox7" type="checkbox" />
    <UButtonGroup v-model="data1" id="checkbox71" type="checkbox" :checkValueArray="data1Check" />
  </UItem>
</UBox>

<script setup lang="ts">
import { reactive, ref } from '#ustra/nuxt'
const data1 = reactive([
  { value: 1, label: 'test1' },
  { value: 2, label: 'test2' },
  { value: 3, label: 'test3' },
  { value: 4, label: 'test4' },
])
const data1Check = ref<string[]>(['1', '3'])
</script>

```
