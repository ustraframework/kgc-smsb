<template>
  <div>
    <v-card>
      <template #title>기능 권한</template>
      <template #subtitle>
        <div></div>
      </template>
    </v-card>

    <v-card>
      <template #title>1) 기능 권한 컴포넌트</template>
      <template #subtitle>
        기능 권한 컴포넌트를 통해 버튼에 대한 권한을 설정할 수 있습니다. <br/>
        - functionId : 메뉴관리에서 추가한 기본버튼의 이벤트명을 functionId 에 바인딩합니다. <br/>
        - notPermitType : 해당 버튼에 대한 권한이 없을 경우에 대한 처리를 결정합니다. disable일 경우 버튼이 비활성화되며 hidden일 경우 버튼이 미표출됩니다.
      </template>
      <template #text>
        <div class="samplebox">
          <UButtonBox left>
            <FunctionAuth functionId="basicNew" notPermitType="disable">
              <UButton text="신규" />
            </FunctionAuth>
            <FunctionAuth functionId="basicSave" notPermitType="disable">
              <UButton text="저장" type="primary"/>
            </FunctionAuth>
          </UButtonBox>
        </div>
        <UMarkdownViewer>{{ md1 }}</UMarkdownViewer>
      </template>
    </v-card>
    <v-card>
      <template #title>2) 기능 권한 이력 관리</template>
      <template #subtitle>
        특정 화면(특히, 메뉴 내의 탭 또는 팝업) 조회 시 이력을 남길 필요가 있다면, <br>
        메뉴관리에서 관련 된 기본버튼을 추가한 뒤 해당 이벤트명을 사용하여 다음과 같은 코드를 해당 화면 내에 작성합니다. <br>
        USTRA_MNU_FNC_ACC_HIST 테이블에 이력이 적재 됩니다. <br>
        * 관련 가이드 : http://guide.ustraframework.kro.kr/ref-doc/11/3Jf9mTRVY4nBD7YNHWZY
      </template>
      <template #text>
        <UMarkdownViewer>{{ md2 }}</UMarkdownViewer>
      </template>
    </v-card>
    <v-card>
      <template #title>3) 개인 정보 조회 이력 관리</template>
      <template #subtitle>
        개인 정보 조회 이력을 등록하기 위해서는 아래와 같은 코드를 API와 관련된 곳에 추가해야 합니다. <br>
        * 관련 가이드 : http://guide.ustraframework.kro.kr/ref-doc/11/3Jf9mTRVY4nBD7YNHWZY
      </template>
      <template #text>
        <UMarkdownViewer>{{ md3 }}</UMarkdownViewer>
      </template>
    </v-card>
  </div>
</template>
<script lang="ts" setup>
import md1 from './md/function-auth-components-1.md'
import md2 from './md/function-auth-components-2.md'
import md3 from './md/function-auth-components-3.md'
import FunctionAuth from '~/components/samples/function-auth/function-auth.vue'
</script>
<style scoped>
.samplebox {
  margin-bottom: 30px;
}
</style>
