<template>
  <UBox style="padding: 5px">
    <UItem :ratio="1" v-if="props.menuData.accessibleAuthGroups">
      <UFieldSet label="접근 가능한 권한 그룹">
        <WjFlexGrid style="height: 300px" :itemsSource="props.menuData.accessibleAuthGroups" :isReadOnly="true">
          <WjFlexGridColumn header="아이디" binding="authGrpId" :width="80" />
          <WjFlexGridColumn header="그룹명" binding="authGrpNm" width="*" />
          <WjFlexGridColumn header="시작일" binding="useSrtDt" :cellTemplate="ctx => $ustra.utils.formatting.date(ctx.value)" align="center" />
          <WjFlexGridColumn header="종료일" binding="useEndDt" :cellTemplate="ctx => $ustra.utils.formatting.date(ctx.value)" align="center" />
        </WjFlexGrid>
      </UFieldSet>
    </UItem>
    <UItem :ratio="1" v-if="props.menuData.accessibleUsers">
      <UFieldSet label="접근 가능 사용자">
        <WjFlexGrid style="height: 300px" :itemsSource="props.menuData.accessibleUsers" :isReadOnly="true">
          <WjFlexGridColumn header="아이디" binding="usrId" :width="80" />
          <WjFlexGridColumn header="사용자 명" binding="usrNm" :width="80" />
          <WjFlexGridColumn header="소속" binding="deptNm" />
          <WjFlexGridColumn header="상태" binding="usrSttCd" :cellTemplate="ctx => useUstraCodeValue('USR_STT_CD', ctx.value)" align="center" />
          <WjFlexGridColumn header="유형" binding="useDvCd" :cellTemplate="ctx => useUstraCodeValue('USE_DV_CD', ctx.value)" align="center" />
          <WjFlexGridColumn header="시작일" binding="useSrtDt" :cellTemplate="ctx => $ustra.utils.formatting.date(ctx.value)" align="center" />
          <WjFlexGridColumn header="종료일" binding="useEndDt" :cellTemplate="ctx => $ustra.utils.formatting.date(ctx.value)" align="center" />
        </WjFlexGrid>
      </UFieldSet>
    </UItem>
  </UBox>
</template>
<script lang="ts" setup>
import { defineProps } from '#ustra/nuxt'
import { UBox, UItem, WjFlexGrid, WjFlexGridColumn, UFieldSet } from '#ustra/nuxt-wijmo/components'
import { Menu, useUstraCodeValue } from '#ustra/nuxt/management'

type MenuData = Menu & { accessibleAuthGroups?: any[]; accessibleUsers?: any[] }

const props = defineProps<{
  menuData: MenuData
}>()
</script>
<script lang="ts">
export default {
  name: 'UstraManagementSystemMenuAuthority',
}
</script>
