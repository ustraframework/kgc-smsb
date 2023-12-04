위의 예제는 모든 태그의 속성의 입력을 허용하는 설정의 예제이다.
```html
<UCkEditor5
  v-model="content"
  :height="200"
  :useSourceEditing="true"
  :htmlSupport="{
      allow: [
      {
          name: /.*/,
          attributes: true,
          classes: true,
          styles: true,
      },
      ],
  }"
  />

<UButton text="글자 색상 변경" @click="() => (content = `<a style='color: blue; text-decoration: underline'>테스트 링크</a>`)" />

<script lang="ts" setup>
const content = ref('<a style="color:red;text-decoration:underline;">테스트 링크</a>')
</script>
```
