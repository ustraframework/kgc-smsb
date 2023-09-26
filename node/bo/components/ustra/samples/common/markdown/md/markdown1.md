```html
<!-- render by prop -->
<UMarkdownViewer :content="markdown1"></UMarkdownViewer>

<!-- render by slot -->
<UMarkdownViewer>{{ markdown1 }}</UMarkdownViewer>

<script lang="ts" setup>
import markdown1 from './md/markdown1.md'
</script>
```
