<template>
  <div>
    <h1 class="bg-black">초기화면</h1>
    <div>
      <Button label="Submit" />
      <Button label="로그인" @click="useRouter().push({ path: '/login', query: { param1: '1' } })" />
      <Button label="로그아웃" @click="useLogout()" />
    </div>
    <div>로그인된 사용자명 : {{ $ustra.auth.user?.userNm }}</div>
  </div>
</template>

<script lang="ts" setup>
const pizza = ref();
console.log('snsId', useKgc().fo.store.system.props['snsId']);
console.log('snsPw', useKgc().fo.store.system.props['snsPw']);
</script>
