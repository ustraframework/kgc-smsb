```html
<UCodeInputBox v-model="codeValue" v-model:objectValue="objectValue" grpCd="SYS_CD" />

<UButton text="codeValue = 'AP'" @click="() => (codeValue = 'AP')" />
<UButton text="codeValue = null" @click="() => (codeValue = null)" />

<script lang="ts" setup>
const codeValue = ref('FO')
const objectValue = ref(null)
</script>
```
