```html
<UButton text="팝업 오픈" @click="showPopup = true"></UButton>
<UCodePopup grpCd="SYS_CD" v-model="showPopup" @selected="item => (selectedItem = item)" />

<script lang="ts" setup>
const showPopup = ref(false)
const selectedItem = ref(null)
</script>
```
