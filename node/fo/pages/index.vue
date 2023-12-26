<template>
  <div>
    <h1 class="bg-black">초기화면</h1>
    <div>
      <Button label="Submit" />
      <Button label="로그인" @click="useRouter().push('/login')" />
      <Button label="로그아웃" @click="useLogout()" />
    </div>
    <div>로그인된 사용자명 : {{ $ustra.auth.user?.userNm }}</div>

    <div class="card flex flex-wrap justify-content-center gap-3">
      <div class="flex align-items-center">
        <Checkbox v-model="pizza" inputId="ingredient1" name="pizza" value="Cheese" />
        <label for="ingredient1" class="ml-2"> Cheese </label>
      </div>
      <div class="flex align-items-center">
        <Checkbox v-model="pizza" inputId="ingredient2" name="pizza" value="Mushroom" />
        <label for="ingredient2" class="ml-2"> Mushroom </label>
      </div>
      <div class="flex align-items-center">
        <Checkbox v-model="pizza" inputId="ingredient3" name="pizza" value="Pepper" />
        <label for="ingredient3" class="ml-2"> Pepper </label>
      </div>
      <div class="flex align-items-center">
        <Checkbox v-model="pizza" inputId="ingredient4" name="pizza" value="Onion" />
        <label for="ingredient4" class="ml-2"> Onion </label>
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>
const pizza = ref();
console.log('snsId', useKgc().fo.store.system.props['snsId'])
console.log('snsPw', useKgc().fo.store.system.props['snsPw'])
</script>
