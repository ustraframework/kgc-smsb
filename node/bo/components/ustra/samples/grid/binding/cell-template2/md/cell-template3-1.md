useMaskingText 메소드를 사용하여 그리드 내의 문자열을 마스킹 처리할 수 있다. 상세한 가이드는 아래 링크를 참조한다.
- 가이드 : http://guide.ustraframework.kro.kr/ref-doc/11/5YzDidCsqxNwyiAlFepU


```html
<WjFlexGrid :isReadOnly="true" :itemsSource="itemsSource">
  <WjFlexGridColumn header="성명" binding="name" :cellTemplate="ctx => useMaskingText('NAME', ctx.value)"></WjFlexGridColumn>
  <WjFlexGridColumn header="아이디" binding="id" :cellTemplate="ctx => useMaskingText('ID', ctx.value)"></WjFlexGridColumn>
  <WjFlexGridColumn header="이메일" binding="email" :cellTemplate="ctx => useMaskingText('EMAIL', ctx.value)"></WjFlexGridColumn>
  <WjFlexGridColumn header="이동전화" binding="mobile" :cellTemplate="ctx => useMaskingText('PHONE', ctx.value)"></WjFlexGridColumn>
</WjFlexGrid>
<script lang="ts" setup>
const itemsSource = ref([
  {
    name: '홍길동',
    id: 'honggildong',
    email: 'home@gmail.com',
    mobile: '010-1234-5678',
  },
])
</script>
```
