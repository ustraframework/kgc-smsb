<template>
  <v-card>
    <template #title> 공통코드 Multi 콤보 박스 </template>
    <template #subtitle
      >UCodeMultiComboBox 컴포넌트를 사용하여 공통 코드를 Multi 선택이 가능한 콤보박스에 바인딩할 수 있다. <br />
      grpCd Prop으로 그룹 코드를 지정하면 그룹 코드에 해당하는 코드 목록이 콤보박스에 바인딩된다. 이 때 초기 값이 null 또는 공백일 경우 value 값은
      목록의 첫번째 항목으로 변경된다. <br />
      <br />
      선택된 value 값을 문자 형태로 변경할 경우 v-model을 사용하며, v-model:objectValue 속성을 사용하여 Object 형태의 수신도 가능하다. 단 해당 속성은
      값을 전달하지는 않으므로 해당 Prop이 변경되어도 현재 선택된 항목이 변경되지는 않는다.
    </template>
    <template #text>
      <UCodeMultiComboBox :grpCd="grpCd" v-model="comboValue" v-model:objectValue="comboObjectValue" style="width: 500px" />

      <div>
        <v-chip class="ma-2" color="pink" label text-color="white">
          <v-icon start icon="mdi-label"></v-icon>
          comboValue : {{ comboValue }}
        </v-chip>
        <v-chip class="ma-2" color="pink" label text-color="white" style="height: auto; overflow: auto; white-space: normal">
          <v-icon start icon="mdi-label"></v-icon>
          comboObjectValue : {{ comboObjectValue }}
        </v-chip>
      </div>

      <div class="ma-2">
        <UButton icon="mdi-comment-edit" text="콤보 박스 값 변경" @click="changeComboValue"></UButton>
        <UButton icon="mdi-comment-edit" text="그룹 코드 변경" @click="() => (grpCd = grpCd === 'SYS_CD' ? 'WORK_DV_CD' : 'SYS_CD')"></UButton>
      </div>

      <UMarkdownViewer :content="desc"></UMarkdownViewer>
    </template>
  </v-card>
</template>
<script lang="ts" setup>
import { ref } from '#ustra/nuxt'
import { UCodeMultiComboBox } from '#ustra/nuxt-wijmo/management/components'
import { useUstraCodeList } from '#ustra/nuxt/management/composables'
import { UButton } from '#ustra/nuxt-wijmo/components'
import { UMarkdownViewer } from '#ustra/nuxt/components'

// @ts-ignore
import desc from './md/code-multi-combo-box1.md'

const comboValue = ref<string[]>([])
const comboObjectValue = ref(null)
const grpCd = ref('SYS_CD')

function changeComboValue() {
  const codes = useUstraCodeList(grpCd.value, true)

  if (codes.length > 0) {
    comboValue.value = [codes[codes.length - 1].dtlCd]
  }
}
</script>
