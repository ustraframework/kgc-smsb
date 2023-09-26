```html
<template>
  <UFileDropBox
    class="mt-2"
    accept="image/*"
    @dropped="
      files => {
        $ustra.global.alert(files.map(f => f.name).join(', \n'))
      }
    "
  />
</template>
```
