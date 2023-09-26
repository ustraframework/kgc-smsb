```html
<template>
  <WjFlexGrid :itemsSource="gridData" :isReadOnly="true" selectionMode="Cell" :initialized="e => (gridControl = e)">
    <WjFlexGridColumn header="이름" binding="name" :width="100" />
    <WjFlexGridColumn header="주소" binding="address" width="*" />
  </WjFlexGrid>
</template>
```
