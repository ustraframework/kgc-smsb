```html
<UBox>
  <UItem>
    <UButtonGroup v-model="data1" id="checkbox91" type="checkbox" width="300" />
    <UButtonGroup v-model="data1" id="checkbox92" type="checkbox" width="400" />
    <UButtonGroup v-model="data1" id="checkbox93" type="checkbox" width="500" />
  </UItem>
</UBox>
<UBox>
  <UItem>
    <UButtonGroup v-model="data2" id="radiobox91" type="radio" width="300" />
    <UButtonGroup v-model="data2" id="radiobox92" type="radio" width="400" />
    <UButtonGroup v-model="data2" id="radiobox93" type="radio" width="500" />
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
const data2 = reactive([
  { value: 1, label: 'test1' },
  { value: 2, label: 'test2' },
  { value: 3, label: 'test3' },
  { value: 4, label: 'test4' },
])
</script>
```
