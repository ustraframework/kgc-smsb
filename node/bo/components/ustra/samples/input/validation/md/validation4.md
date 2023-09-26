

- 하위 컴포넌트
```html
<template>
  <div>
    <UMessage message="2개 항목을 동일하게 입력하세요." />
    <WjInputMask v-model="textValue1" />
    <WjInputMask v-model="textValue2" />
  </div>
</template>
<script lang="ts" setup>
import { WjInputMask } from '#ustra/nuxt-wijmo/components'

const textValue1 = ref('')
const textValue2 = ref('')

// textValue1, textValue2 값이 변경될 경우, validation 재실행
watchValidationData([textValue1, textValue2])

defineExpose({
  validate: () => {
    if (!textValue1.value || !textValue2.value) {
      return '필수 입력이예요!'
    }

    if (textValue1.value !== textValue2.value) {
      return '동일한 값을 입력하세요!'
    }
    return true
  },
})
</script>
```

- 상위 컴포넌트
```html
<template>
  <UValidationGroup ref="validationGroup">
    <CustomSub />
  </UValidationGroup>

  <div class="mt-2">
    <UButton text="Validate" @validate="() => {}" @click="() => validationGroup.validate()" />
  </div>
</template>
<script lang="ts" setup>
import { UValidationGroup } from '#ustra/nuxt-wijmo/components'

const validationGroup = ref<InstanceType<typeof UValidationGroup>>()
</script>
```
